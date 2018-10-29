package com.nbu.sportapp.nbusportapp.entity;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;
import java.util.ArrayList;

@Entity
@Table(name = "teams")
@EntityListeners(AuditingEntityListener.class)
public class Team extends BaseEntity {
    @NotBlank
    private String name;

//    @NotBlank
//    private Long leagueId;
//
//    @Column
//    private ArrayList playersIds;


    public Team(String name) {
        this.name = name;
    }

    public Team() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
