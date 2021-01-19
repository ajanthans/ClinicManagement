package com.nets.patientvisit.patientvisit.controller;

import com.nets.patientvisit.patientvisit.dto.Visit;
import com.nets.patientvisit.patientvisit.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Profile("patient")
@RestController
@RequestMapping(path = "/v1/visits")
public class VisitController {

    private final VisitService visitService;

    public VisitController(VisitService visitService) {
        this.visitService = visitService;
    }

    @PostMapping
    public ResponseEntity<Visit> createVisit(@Valid @RequestBody Visit visit) {
        return new ResponseEntity<>(visitService.createVisit(visit), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Visit>> retrieveVisits() {
        return new ResponseEntity<>(visitService.retrieveVisits(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Visit> retrieveVisit(@PathVariable(name = "id") String id) {
        return new ResponseEntity<>(visitService.retrieveVisit(id), HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Visit> updateVisit(@PathVariable(name = "id") String id, @RequestBody Visit visit) {
        return new ResponseEntity<>(visitService.updateVisit(id, visit), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity deleteVisit(@PathVariable(name = "id") String id) {
        visitService.deleteVisit(id);
        return ResponseEntity.ok().build();
    }
}
