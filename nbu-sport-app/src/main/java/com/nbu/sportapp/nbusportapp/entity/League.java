package com.nbu.sportapp.nbusportapp.entity;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;
import java.util.ArrayList;

@Entity
@Table(name = "leagues")
@EntityListeners(AuditingEntityListener.class)
public class League extends BaseEntity {
    @NotBlank
    private String name;

//    @Column
    //    private ArrayList teamIds;
    //    @Column
//    private Long sportCategoryId;


    public League(String name) {
        this.name = name;
    }

    public League() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
