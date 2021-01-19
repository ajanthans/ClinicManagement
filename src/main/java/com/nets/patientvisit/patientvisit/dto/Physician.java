package com.nets.patientvisit.patientvisit.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.Set;

@ToString
@Getter
@Setter
public class Physician {

    @NotEmpty
    private String id;
    @NotEmpty
    private String name;
    private LocalDateTime createdDatetime;
    private LocalDateTime modifiedDatetime;
    private String createdBy;
    private String modifiedBy;
}
