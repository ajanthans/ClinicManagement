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
public class Billing {

    @NotEmpty
    private String id;
    @NotEmpty
    private String physicianId;
    @NotEmpty
    private String patientId;
    @NotNull
    private LocalDateTime billedDatetime;


}
