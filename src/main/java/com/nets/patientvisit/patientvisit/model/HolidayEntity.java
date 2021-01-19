package com.nets.patientvisit.patientvisit.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

@ToString
@Getter
@Setter
@Entity
public class HolidayEntity {
    @Id
    private String name;
    @Column(nullable = false)
    private LocalDate holidayDate;
    private LocalDateTime createdDatetime = LocalDateTime.now();
    private LocalDateTime modifiedDatetime = LocalDateTime.now();
    private String createdBy;
    private String modifiedBy;

    public HolidayEntity() {

    }

    public HolidayEntity(String name, LocalDate holidayDate) {
        this.name = name;
        this.holidayDate = holidayDate;
    }
}
