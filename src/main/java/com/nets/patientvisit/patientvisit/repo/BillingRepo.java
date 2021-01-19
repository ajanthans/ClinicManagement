package com.nets.patientvisit.patientvisit.repo;

import com.nets.patientvisit.patientvisit.model.BillingEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillingRepo extends CrudRepository<BillingEntity, String> {
    List<BillingEntity> findAll();

}
