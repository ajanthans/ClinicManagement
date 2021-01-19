package com.nets.patientvisit.patientvisit.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@ToString
@Getter
@Setter
public class Holiday {
    @NotEmpty
    private String name;
    @NotNull
    private LocalDate holidayDate;
    private LocalDateTime createdDatetime;
    private LocalDateTime modifiedDatetime;
    private String createdBy;
    private String modifiedBy;
}
