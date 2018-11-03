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
@Table(name = "sport_categories")
@EntityListeners(AuditingEntityListener.class)
public class SportCategory extends AbstractPersistable<Long> {

    private Long id;
    @NotBlank
    private String name;


    // sportCategory promenlivata ot league
    @OneToMany(targetEntity = League.class, mappedBy = "sportCategory", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<League> leagues = new HashSet<>();


    public SportCategory(){}

    public SportCategory(String name, Set<League> leagues) {
        this.name = name;
        this.leagues = leagues;
    }

    public Set<League> getLeagues() {
        return leagues;
    }

    public void setLeagues(Set<League> leagues) {
        this.leagues = leagues;
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
