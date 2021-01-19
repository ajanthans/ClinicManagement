package com.nets.patientvisit.patientvisit.mapper;

import com.nets.patientvisit.patientvisit.dto.Billing;
import com.nets.patientvisit.patientvisit.model.BillingEntity;
import com.nets.patientvisit.patientvisit.model.PatientEntity;
import com.nets.patientvisit.patientvisit.model.PhysicianEntity;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

public class BillingMapper {

    public static List<Billing> map(final List<BillingEntity> entities) {
        return entities.stream().map(BillingMapper::map).collect(Collectors.toList());
    }

    public static Billing map(final BillingEntity entity) {
        final Billing resource = new Billing();

        ofNullable(entity.getId())
                .ifPresent(resource::setId);
        ofNullable(entity.getBilledDatetime())
                .ifPresent(resource::setBilledDatetime);
        ofNullable(entity.getPhysician())
                .map(PhysicianEntity::getId)
                .ifPresent(resource::setPhysicianId);
        ofNullable(entity.getPatient())
                .map(PatientEntity::getId)
                .ifPresent(resource::setPatientId);
        return resource;
    }

    public static void merge(BillingEntity source, BillingEntity destination) {
        ofNullable(source.getBilledDatetime())
                .ifPresent(destination::setBilledDatetime);
        ofNullable(source.getPatient())
                .ifPresent(destination::setPatient);
        ofNullable(source.getPhysician())
                .ifPresent(destination::setPhysician);
    }
}
