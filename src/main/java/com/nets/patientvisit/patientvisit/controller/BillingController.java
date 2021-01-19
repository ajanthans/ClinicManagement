package com.nets.patientvisit.patientvisit.controller;

import com.nets.patientvisit.patientvisit.dto.Billing;
import com.nets.patientvisit.patientvisit.services.BillingService;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Profile("billing")
@RestController
@RequestMapping(path = "/v1/billing")
public class BillingController {

    private final BillingService billingService;

    public BillingController(BillingService billingService) {
        this.billingService = billingService;
    }

    @GetMapping
    public ResponseEntity<List<Billing>> retrievePatients() {
        return new ResponseEntity<>(billingService.retrieveBillings(), HttpStatus.OK);
    }

}
