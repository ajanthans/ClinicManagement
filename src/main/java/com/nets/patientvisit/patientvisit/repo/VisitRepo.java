package com.nets.patientvisit.patientvisit.repo;

import com.nets.patientvisit.patientvisit.model.VisitEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VisitRepo extends CrudRepository<VisitEntity, String> {
    List<VisitEntity> findAll();

}
