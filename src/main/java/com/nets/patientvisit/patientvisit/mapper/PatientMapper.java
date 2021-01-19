package com.nets.patientvisit.patientvisit.mapper;

import com.nets.patientvisit.patientvisit.dto.Patient;
import com.nets.patientvisit.patientvisit.model.PatientEntity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

public class PatientMapper {
    public static PatientEntity map(final Patient patient) {
        final PatientEntity entity = new PatientEntity();

        ofNullable(patient.getId())
                .ifPresent(entity::setId);
        ofNullable(patient.getAge())
                .ifPresent(entity::setAge);
        ofNullable(patient.getGender())
                .ifPresent(entity::setGender);
        ofNullable(patient.getName())
                .ifPresent(entity::setName);
        ofNullable(patient.getCreatedBy())
                .ifPresent(entity::setCreatedBy);
        ofNullable(patient.getCreatedDatetime())
                .ifPresentOrElse(entity::setCreatedDatetime,
                        () -> entity.setCreatedDatetime(LocalDateTime.now()));

        entity.setModifiedDatetime(LocalDateTime.now());
        return entity;
    }

    public static List<Patient> map(final List<PatientEntity> entities) {
        return entities.stream().map(PatientMapper::map).collect(Collectors.toList());
    }

    public static Patient map(final PatientEntity entity) {
        final Patient resource = new Patient();

        ofNullable(entity.getId())
                .ifPresent(resource::setId);
        ofNullable(entity.getAge())
                .ifPresent(resource::setAge);
        ofNullable(entity.getGender())
                .ifPresent(resource::setGender);
        ofNullable(entity.getName())
                .ifPresent(resource::setName);
        ofNullable(entity.getCreatedBy())
                .ifPresent(resource::setCreatedBy);
        ofNullable(entity.getCreatedDatetime())
                .ifPresent(resource::setCreatedDatetime);
        ofNullable(entity.getModifiedDatetime())
                .ifPresent(resource::setModifiedDatetime);
        return resource;
    }

    public static void merge(PatientEntity source, PatientEntity destination) {

        ofNullable(source.getAge())
                .ifPresent(destination::setAge);
        ofNullable(source.getGender())
                .ifPresent(destination::setGender);
        ofNullable(source.getName())
                .ifPresent(destination::setName);
        ofNullable(source.getCreatedBy())
                .ifPresent(destination::setCreatedBy);
        ofNullable(source.getModifiedDatetime())
                .ifPresent(destination::setModifiedDatetime);
    }
}
