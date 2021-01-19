package com.nets.patientvisit.patientvisit.mapper;

import com.nets.patientvisit.patientvisit.dto.Visit;
import com.nets.patientvisit.patientvisit.model.PatientEntity;
import com.nets.patientvisit.patientvisit.model.PhysicianEntity;
import com.nets.patientvisit.patientvisit.model.VisitEntity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

public class VisitMapper {
    public static VisitEntity map(final Visit resource) {
        final VisitEntity entity = new VisitEntity();

        ofNullable(resource.getId())
                .ifPresent(entity::setId);
        ofNullable(resource.getVisitDatetime())
                .ifPresent(entity::setVisitDatetime);
        ofNullable(resource.getReason())
                .ifPresent(entity::setReason);
        ofNullable(resource.getCreatedBy())
                .ifPresent(entity::setCreatedBy);
        ofNullable(resource.getModifiedBy())
                .ifPresent(entity::setModifiedBy);
        ofNullable(resource.getCreatedDatetime())
                .ifPresentOrElse(entity::setCreatedDatetime,
                        () -> entity.setCreatedDatetime(LocalDateTime.now()));

        entity.setModifiedDatetime(LocalDateTime.now());
        return entity;
    }

    public static List<Visit> map(final List<VisitEntity> entities) {
        return entities.stream().map(VisitMapper::map).collect(Collectors.toList());
    }

    public static Visit map(final VisitEntity entity) {
        final Visit resource = new Visit();

        ofNullable(entity.getId())
                .ifPresent(resource::setId);
        ofNullable(entity.getVisitDatetime())
                .ifPresent(resource::setVisitDatetime);
        ofNullable(entity.getReason())
                .ifPresent(resource::setReason);
        ofNullable(entity.getPhysician())
                .map(PhysicianEntity::getId)
                .ifPresent(resource::setPhysicianId);
        ofNullable(entity.getPatient())
                .map(PatientEntity::getId)
                .ifPresent(resource::setPatientId);

        ofNullable(entity.getCreatedBy())
                .ifPresent(resource::setCreatedBy);
        ofNullable(entity.getModifiedBy())
                .ifPresent(resource::setModifiedBy);
        ofNullable(entity.getCreatedDatetime())
                .ifPresent(resource::setCreatedDatetime);
        ofNullable(entity.getModifiedDatetime())
                .ifPresent(resource::setModifiedDatetime);
        return resource;
    }

    public static void merge(VisitEntity source, VisitEntity destination) {
        ofNullable(source.getVisitDatetime())
                .ifPresent(destination::setVisitDatetime);
        ofNullable(source.getReason())
                .ifPresent(destination::setReason);
        ofNullable(source.getCreatedBy())
                .ifPresent(destination::setCreatedBy);
        ofNullable(source.getModifiedBy())
                .ifPresent(destination::setModifiedBy);
        ofNullable(source.getModifiedDatetime())
                .ifPresent(destination::setModifiedDatetime);
    }
}
