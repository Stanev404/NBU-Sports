package com.nbu.sportapp.nbusportapp.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

/**
 * Every class that needs an id have to inherit nbu.sport.app.entity.BaseEntity.
 * This entity ensures an id for every class that is in the DataBase.
 */

@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    BaseEntity() {
    }

    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

}