package com.nets.patientvisit.patientvisit.repo;

import com.nets.patientvisit.patientvisit.model.HolidayEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HolidayRepo extends CrudRepository<HolidayEntity, String> {
    List<HolidayEntity> findAll();

}
