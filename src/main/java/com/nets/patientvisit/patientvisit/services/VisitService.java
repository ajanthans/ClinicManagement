package com.nets.patientvisit.patientvisit.services;

import com.nets.patientvisit.patientvisit.dto.Visit;
import com.nets.patientvisit.patientvisit.mapper.VisitMapper;
import com.nets.patientvisit.patientvisit.model.PatientEntity;
import com.nets.patientvisit.patientvisit.model.PhysicianEntity;
import com.nets.patientvisit.patientvisit.model.VisitEntity;
import com.nets.patientvisit.patientvisit.repo.VisitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class VisitService {

    @Autowired(required = false)
    private BillingService billingService;

    private final VisitRepo visitRepo;

    private final PatientService patientService;

    private final PhysicianService physicianService;

    private final HolidayService holidayService;

    public VisitService(VisitRepo visitRepo, PhysicianService physicianService, PatientService patientService, HolidayService holidayService) {
        this.visitRepo = visitRepo;
        this.physicianService = physicianService;
        this.patientService = patientService;
        this.holidayService = holidayService;
    }


    public Visit createVisit(@Valid Visit visit) {
        if (visitRepo.existsById(visit.getId())) {
            throw new DuplicateKeyException("Visit id already exists, please use another id");
        }
        VisitEntity visitEntity = VisitMapper.map(visit);

        holidayService.isOnHoliday(visitEntity.getModifiedDatetime());


        PhysicianEntity physician = physicianService.retrievePhysicianEntity(visit.getPhysicianId());
        visitEntity.setPhysician(physician);

        PatientEntity patient = patientService.retrievePatientEntity(visit.getPatientId());
        visitEntity.setPatient(patient);

        final VisitEntity savedEntity = visitRepo.save(visitEntity);

        if (billingService != null) {
            billingService.createBilling(visitEntity);
        }
        return VisitMapper.map(savedEntity);
    }

    public List<Visit> retrieveVisits() {
        List<VisitEntity> all = visitRepo.findAll();

        return VisitMapper.map(all);
    }

    public Visit retrieveVisit(String id) {
        Optional<VisitEntity> byId = visitRepo.findById(id);
        if (byId.isPresent()) {
            return VisitMapper.map(byId.get());
        } else {
            throw new EntityNotFoundException("Visit not found for the id");
        }
    }

    public Visit updateVisit(String id, Visit visit) {
        Optional<VisitEntity> byId = visitRepo.findById(id);
        if (byId.isPresent()) {
            VisitEntity dbVisitEntity = byId.get();
            VisitEntity requestVisitEntity = VisitMapper.map(visit);
            VisitMapper.merge(requestVisitEntity, dbVisitEntity);

            holidayService.isOnHoliday(dbVisitEntity.getModifiedDatetime());

            PhysicianEntity physician = physicianService.retrievePhysicianEntity(visit.getPhysicianId());
            dbVisitEntity.setPhysician(physician);

            PatientEntity patient = patientService.retrievePatientEntity(visit.getPatientId());
            dbVisitEntity.setPatient(patient);

            VisitEntity updatedVisitEntity = visitRepo.save(dbVisitEntity);
            return VisitMapper.map(updatedVisitEntity);
        } else {
            throw new EntityNotFoundException("Visit not found for the id");
        }
    }

    public void deleteVisit(String id) {
        visitRepo.deleteById(id);
    }
}
