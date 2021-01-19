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
public class PhysicianEntity {
    @Id
    private String id;
    @Column(nullable = false)
    private String name;
    private LocalDateTime createdDatetime;
    private LocalDateTime modifiedDatetime;
    private String createdBy;
    private String modifiedBy;

    @OneToMany(mappedBy = "physician")
    private Set<VisitEntity> visits;

    @OneToMany(mappedBy = "physician")
    private Set<BillingEntity> billings;
}
