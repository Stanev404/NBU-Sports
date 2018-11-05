package com.nbu.sportapp.nbusportapp.entity.business;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "teams")
@EntityListeners(AuditingEntityListener.class)
public class Team extends AbstractPersistable<Long> {
    private Long id;

    @NotBlank
    private String nameOfTeam;

    // we will create one transient field for leagueId
    @Transient
    private Long leagueId;

    @ManyToOne
    @JoinColumn(name = "league_id")
    @JsonBackReference
    private League league;

    // team promenlivata ot player
    @OneToMany(targetEntity = Player.class, mappedBy = "team", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Player> players = new HashSet<>();



    public Team(String nameOfTeam) {
        this.nameOfTeam = nameOfTeam;
    }

    public Team() {
    }


    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }

    public String getNameOfTeam() {
        return nameOfTeam;
    }

    public void setNameOfTeam(String nameOfTeam) {
        this.nameOfTeam = nameOfTeam;
    }

    public Long getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(Long leagueId) {
        this.leagueId = leagueId;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
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
