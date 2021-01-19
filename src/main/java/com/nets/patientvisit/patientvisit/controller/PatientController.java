package com.nets.patientvisit.patientvisit.controller;

import com.nets.patientvisit.patientvisit.dto.Patient;
import com.nets.patientvisit.patientvisit.services.PatientService;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Profile("patient")
@RestController
@RequestMapping(path = "/v1/patients")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping
    public ResponseEntity<Patient> createPatient(@Valid @RequestBody Patient patient) {
        return new ResponseEntity<>(patientService.createPatient(patient), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Patient>> retrievePatients() {
        return new ResponseEntity<>(patientService.retrievePatients(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Patient> retrievePatient(@PathVariable(name = "id") String id) {
        return new ResponseEntity<>(patientService.retrievePatient(id), HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable(name = "id") String id, @RequestBody Patient patient) {
        return new ResponseEntity<>(patientService.updatePatient(id, patient), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity deletePatient(@PathVariable(name = "id") String id) {
        patientService.deletePatient(id);
        return ResponseEntity.ok().build();
    }
}
