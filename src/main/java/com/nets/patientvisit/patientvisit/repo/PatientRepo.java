package com.nets.patientvisit.patientvisit.repo;

import com.nets.patientvisit.patientvisit.model.PatientEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepo extends CrudRepository<PatientEntity, String> {

    List<PatientEntity> findAll();
}
