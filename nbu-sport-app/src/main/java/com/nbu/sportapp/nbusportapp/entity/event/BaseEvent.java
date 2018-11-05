package com.nbu.sportapp.nbusportapp.entity.event;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.nbu.sportapp.nbusportapp.entity.user.User;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.List;

public class BaseEvent extends AbstractPersistable<Long> {

    private Long id;

    @NotBlank
    private String title;

    @NotBlank
    private String description;

    @NotBlank
    private Long creatorUserId;

    // BaseEvent promenlivata ot comment
    @OneToMany(targetEntity = Comment.class, mappedBy = "baseEvent", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    List<Comment> comments;

    BaseEvent(){

    }

    public BaseEvent(String title, String description, Long creatorUserId) {
        this.title = title;
        this.description = description;
        this.creatorUserId = creatorUserId;
    }
}
