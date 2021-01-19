package com.nets.patientvisit.patientvisit.dto;

import com.nets.patientvisit.patientvisit.model.PatientEntity.GENDER;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@ToString
@Getter
@Setter
public class Patient {
    @NotEmpty
    private String id;
    @NotEmpty
    private String name;
    @NotNull
    private Integer age;
    @NotNull
    private GENDER gender;
    private LocalDateTime createdDatetime;
    private LocalDateTime modifiedDatetime;
    private String createdBy;

}
