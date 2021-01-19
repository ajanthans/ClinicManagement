package com.nets.patientvisit.patientvisit.mapper;

import com.nets.patientvisit.patientvisit.dto.Physician;
import com.nets.patientvisit.patientvisit.model.PhysicianEntity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

public class PhysicianMapper {
    public static PhysicianEntity map(final Physician resource) {
        final PhysicianEntity entity = new PhysicianEntity();

        ofNullable(resource.getId())
                .ifPresent(entity::setId);
        ofNullable(resource.getName())
                .ifPresent(entity::setName);
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

    public static List<Physician> map(final List<PhysicianEntity> entities) {
        return entities.stream().map(PhysicianMapper::map).collect(Collectors.toList());
    }

    public static Physician map(final PhysicianEntity entity) {
        final Physician resource = new Physician();

        ofNullable(entity.getId())
                .ifPresent(resource::setId);
        ofNullable(entity.getName())
                .ifPresent(resource::setName);
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

    public static void merge(PhysicianEntity source, PhysicianEntity destination) {
        ofNullable(source.getName())
                .ifPresent(destination::setName);
        ofNullable(source.getCreatedBy())
                .ifPresent(destination::setCreatedBy);
        ofNullable(source.getModifiedBy())
                .ifPresent(destination::setModifiedBy);
        ofNullable(source.getModifiedDatetime())
                .ifPresent(destination::setModifiedDatetime);
    }
}
