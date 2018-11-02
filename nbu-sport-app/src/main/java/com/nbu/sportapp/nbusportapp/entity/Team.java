package com.nbu.sportapp.nbusportapp.entity;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "teams")
@EntityListeners(AuditingEntityListener.class)
public class Team extends BaseEntity {
    @NotBlank
    private String name;

    @ManyToOne
    @JoinColumn(name = "league_id")
    private League league;

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


}
