package com.nets.patientvisit.patientvisit.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@ToString
@Getter
@Setter
public class Visit {

    @NotEmpty
    private String id;
    @NotNull
    private LocalDateTime visitDatetime;
    @NotNull
    private String reason;
    @NotEmpty
    private String physicianId;
    @NotEmpty
    private String patientId;

    private LocalDateTime createdDatetime;
    private LocalDateTime modifiedDatetime;
    private String createdBy;
    private String modifiedBy;


}
