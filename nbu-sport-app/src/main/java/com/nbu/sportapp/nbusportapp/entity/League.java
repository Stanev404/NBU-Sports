package com.nbu.sportapp.nbusportapp.entity;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "leagues")
@EntityListeners(AuditingEntityListener.class)
public class League extends BaseEntity {
    @NotBlank
    private String name;

    // league promenlivata ot team
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "league")
    private Set<Team> teams = new HashSet<>();
//    @Column
    //    private ArrayList teamIds;
    //    @Column
//    private Long sportCategoryId;


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


}
