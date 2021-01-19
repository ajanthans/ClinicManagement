package com.nets.patientvisit.patientvisit.services;

import com.nets.patientvisit.patientvisit.dto.Patient;
import com.nets.patientvisit.patientvisit.mapper.PatientMapper;
import com.nets.patientvisit.patientvisit.model.PatientEntity;
import com.nets.patientvisit.patientvisit.repo.PatientRepo;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    private final PatientRepo patientRepo;
    private final HolidayService holidayService;


    public PatientService(PatientRepo patientRepo, HolidayService holidayService) {
        this.patientRepo = patientRepo;
        this.holidayService = holidayService;
    }

    public Patient createPatient(@Valid Patient patient) {
        if (patientRepo.existsById(patient.getId())) {
            throw new DuplicateKeyException("Patient id already exists, please use another id");
        }
        PatientEntity patientEntity = PatientMapper.map(patient);

        holidayService.isOnHoliday(patientEntity.getModifiedDatetime());

        final PatientEntity savedEntity = patientRepo.save(patientEntity);

        return PatientMapper.map(savedEntity);
    }

    public List<Patient> retrievePatients() {
        List<PatientEntity> all = patientRepo.findAll();

        return PatientMapper.map(all);
    }

    public Patient retrievePatient(String id) {
        Optional<PatientEntity> byId = patientRepo.findById(id);
        if (byId.isPresent()) {
            return PatientMapper.map(byId.get());
        } else {
            throw new EntityNotFoundException("Patient not found for the id");
        }
    }

    public Patient updatePatient(String id, Patient patient) {
        Optional<PatientEntity> byId = patientRepo.findById(id);
        if (byId.isPresent()) {
            PatientEntity dbPatientEntity = byId.get();
            PatientEntity requestPatientEntity = PatientMapper.map(patient);

            holidayService.isOnHoliday(requestPatientEntity.getModifiedDatetime());

            PatientMapper.merge(requestPatientEntity, dbPatientEntity);
            PatientEntity updatedPatientEntity = patientRepo.save(dbPatientEntity);
            return PatientMapper.map(updatedPatientEntity);
        } else {
            throw new EntityNotFoundException("Patient not found for the id");
        }
    }

    public void deletePatient(String id) {
        patientRepo.deleteById(id);
    }


    public PatientEntity retrievePatientEntity(String id) {
        Optional<PatientEntity> byId = patientRepo.findById(id);
        if (byId.isPresent()) {
            return byId.get();
        } else {
            throw new EntityNotFoundException("Patient not found for the id");
        }
    }
}
