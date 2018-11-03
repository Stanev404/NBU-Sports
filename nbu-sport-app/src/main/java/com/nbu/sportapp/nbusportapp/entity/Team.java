package com.nbu.sportapp.nbusportapp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "teams")
@EntityListeners(AuditingEntityListener.class)
public class Team extends AbstractPersistable<Long> {
    private Long id;

    @NotBlank
    private String name;

    // we will create one transient field for leagueId
    @Transient
    private Long leagueId;

    @ManyToOne
    @JoinColumn(name = "league_id")
    @JsonBackReference
    private League league;



    public Team(String name) {
        this.name = name;
    }

    public Team() {
    }


    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(Long leagueId) {
        this.leagueId = leagueId;
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
