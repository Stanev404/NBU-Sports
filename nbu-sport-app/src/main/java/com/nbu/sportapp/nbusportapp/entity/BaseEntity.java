package com.nbu.sportapp.nbusportapp.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Every class that needs an id have to inherit BaseEntity.
 * This entity ensures an id for every class that is in the DataBase.
 */

@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    private String id;

    BaseEntity() {
    }

    public String getId() {
        return id;
    }

    private void setId(String id) {
        this.id = id;
    }

}