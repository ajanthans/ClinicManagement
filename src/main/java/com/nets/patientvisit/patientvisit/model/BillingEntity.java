package com.nets.patientvisit.patientvisit.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@ToString
@Getter
@Setter
@Entity
public class BillingEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private String id;
    @Column(nullable = false)
    private LocalDateTime billedDatetime;

    @ManyToOne
    @JoinColumn(name = "physicianId", nullable = false)
    private PhysicianEntity physician;

    @ManyToOne
    @JoinColumn(name = "patientId", nullable = false)
    private PatientEntity patient;
}
