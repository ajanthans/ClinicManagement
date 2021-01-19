package com.nets.patientvisit.patientvisit.services;

import com.nets.patientvisit.patientvisit.dto.Physician;
import com.nets.patientvisit.patientvisit.mapper.PhysicianMapper;
import com.nets.patientvisit.patientvisit.model.PhysicianEntity;
import com.nets.patientvisit.patientvisit.repo.PhysicianRepo;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class PhysicianService {

    private final PhysicianRepo physicianRepo;
    private final HolidayService holidayService;

    public PhysicianService(PhysicianRepo physicianRepo, HolidayService holidayService) {
        this.physicianRepo = physicianRepo;
        this.holidayService = holidayService;
    }

    public Physician createPhysician(@Valid Physician physician) {
        if (physicianRepo.existsById(physician.getId())) {
            throw new DuplicateKeyException("Physician id already exists, please use another id");
        }
        PhysicianEntity physicianEntity = PhysicianMapper.map(physician);

        holidayService.isOnHoliday(physicianEntity.getModifiedDatetime());

        final PhysicianEntity savedEntity = physicianRepo.save(physicianEntity);

        return PhysicianMapper.map(savedEntity);
    }

    public List<Physician> retrievePhysicians() {
        List<PhysicianEntity> all = physicianRepo.findAll();

        return PhysicianMapper.map(all);
    }

    public Physician retrievePhysician(String id) {
        Optional<PhysicianEntity> byId = physicianRepo.findById(id);
        if (byId.isPresent()) {
            return PhysicianMapper.map(byId.get());
        } else {
            throw new EntityNotFoundException("Physician not found for the id");
        }
    }

    public Physician updatePhysician(String id, Physician physician) {
        Optional<PhysicianEntity> byId = physicianRepo.findById(id);
        if (byId.isPresent()) {
            PhysicianEntity dbPhysicianEntity = byId.get();
            PhysicianEntity requestPhysicianEntity = PhysicianMapper.map(physician);

            holidayService.isOnHoliday(requestPhysicianEntity.getModifiedDatetime());

            PhysicianMapper.merge(requestPhysicianEntity, dbPhysicianEntity);
            PhysicianEntity updatedPhysicianEntity = physicianRepo.save(dbPhysicianEntity);
            return PhysicianMapper.map(updatedPhysicianEntity);
        } else {
            throw new EntityNotFoundException("Physician not found for the id");
        }
    }

    public void deletePhysician(String id) {
        physicianRepo.deleteById(id);
    }


    public PhysicianEntity retrievePhysicianEntity(String id) {
        Optional<PhysicianEntity> byId = physicianRepo.findById(id);
        if (byId.isPresent()) {
            return byId.get();
        } else {
            throw new EntityNotFoundException("Physician not found for the id");
        }
    }
}
