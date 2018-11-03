package com.nbu.sportapp.nbusportapp.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.apache.tomcat.jni.Address;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "leagues")
@EntityListeners(AuditingEntityListener.class)
public class League extends AbstractPersistable<Long> {

    private Long id;
    @NotBlank
    private String name;

    // league promenlivata ot team
    @OneToMany(targetEntity = Team.class, mappedBy = "league", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Team> teams = new HashSet<>();


    public League(String name, Set<Team> teams) {
        this.name = name;
        this.teams = teams;
    }

    public League() {
    }


    public Set<Team> getTeams() {
        return teams;
    }

    public void setTeams(Set<Team> teams) {
        this.teams = teams;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
