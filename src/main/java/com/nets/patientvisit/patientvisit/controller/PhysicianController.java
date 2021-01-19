package com.nets.patientvisit.patientvisit.controller;

import com.nets.patientvisit.patientvisit.dto.Physician;
import com.nets.patientvisit.patientvisit.services.PhysicianService;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Profile("patient")
@RestController
@RequestMapping(path = "/v1/physicians")
public class PhysicianController {

    private final PhysicianService physicianService;

    public PhysicianController(PhysicianService physicianService) {
        this.physicianService = physicianService;
    }

    @PostMapping
    public ResponseEntity<Physician> createPhysician(@Valid @RequestBody Physician physician) {
        return new ResponseEntity<>(physicianService.createPhysician(physician), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Physician>> retrievePhysicians() {
        return new ResponseEntity<>(physicianService.retrievePhysicians(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Physician> retrievePhysician(@PathVariable(name = "id") String id) {
        return new ResponseEntity<>(physicianService.retrievePhysician(id), HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Physician> updatePhysician(@PathVariable(name = "id") String id, @RequestBody Physician physician) {
        return new ResponseEntity<>(physicianService.updatePhysician(id, physician), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity deletePhysician(@PathVariable(name = "id") String id) {
        physicianService.deletePhysician(id);
        return ResponseEntity.ok().build();
    }
}
