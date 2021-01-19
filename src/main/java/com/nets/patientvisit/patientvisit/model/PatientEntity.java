package com.nets.patientvisit.patientvisit.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.Set;

@ToString
@Getter
@Setter
@Entity
public class PatientEntity {
    public enum GENDER {
        MALE,
        FEMALE,
        OTHER
    }

    @Id
    private String id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Integer age;
    @Column(nullable = false)
    private GENDER gender;
    private LocalDateTime createdDatetime;
    private LocalDateTime modifiedDatetime;
    private String createdBy;

    @OneToMany(mappedBy = "patient")
    private Set<VisitEntity> visits;

    @OneToMany(mappedBy = "patient")
    private Set<BillingEntity> billings;
}
