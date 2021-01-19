package com.nets.patientvisit.patientvisit.services;

import com.nets.patientvisit.patientvisit.dto.Billing;
import com.nets.patientvisit.patientvisit.mapper.BillingMapper;
import com.nets.patientvisit.patientvisit.model.BillingEntity;
import com.nets.patientvisit.patientvisit.model.VisitEntity;
import com.nets.patientvisit.patientvisit.repo.BillingRepo;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Profile("billing")
@Service
public class BillingService {

    private final BillingRepo billingRepo;

    public BillingService(BillingRepo billingRepo) {
        this.billingRepo = billingRepo;
    }

    public Billing createBilling(VisitEntity visitEntity) {
        BillingEntity billingEntity = new BillingEntity();
        billingEntity.setBilledDatetime(LocalDateTime.now());
        billingEntity.setPhysician(visitEntity.getPhysician());
        billingEntity.setPatient(visitEntity.getPatient());

        final BillingEntity savedEntity = billingRepo.save(billingEntity);

        return BillingMapper.map(savedEntity);
    }

    public List<Billing> retrieveBillings() {
        List<BillingEntity> all = billingRepo.findAll();
        return BillingMapper.map(all);
    }
}
