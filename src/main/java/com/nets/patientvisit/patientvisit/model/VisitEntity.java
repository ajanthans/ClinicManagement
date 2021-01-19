package com.nets.patientvisit.patientvisit.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@ToString
@Getter
@Setter
@Entity
public class VisitEntity {

    @Id
    private String id;
    @Column(nullable = false)
    private LocalDateTime visitDatetime;
    private String reason;
    private LocalDate holidayDate;
    private LocalDateTime createdDatetime;
    private LocalDateTime modifiedDatetime;
    private String createdBy;
    private String modifiedBy;

    @ManyToOne
    @JoinColumn(name="physicianId", nullable=false)
    private PhysicianEntity physician;

    @ManyToOne
    @JoinColumn(name="patientId", nullable=false)
    private PatientEntity patient;
}
