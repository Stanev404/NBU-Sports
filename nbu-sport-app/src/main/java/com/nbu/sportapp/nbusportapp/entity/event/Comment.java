package com.nbu.sportapp.nbusportapp.entity.event;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.nbu.sportapp.nbusportapp.entity.user.User;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comments")
@EntityListeners(AuditingEntityListener.class)
public class Comment extends AbstractPersistable<Long> {

    private Long id;

    // MAYBE TRANSIENT - ico plovdiv me chaka trqbva da slizam :D
    @NotBlank
    private Long publisherUserId;

    // we will create one transient field for baseEventId
    @Transient
    private Long baseEventId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "baseEvent_id")
    @JsonBackReference
    private BaseEvent baseEvent;

    public Comment() {
    }

    public Long getPublisherUserId() {
        return publisherUserId;
    }

    public void setPublisherUserId(Long publisherUserId) {
        this.publisherUserId = publisherUserId;
    }

    public Long getBaseEventId() {
        return baseEventId;
    }

    public void setBaseEventId(Long baseEventId) {
        this.baseEventId = baseEventId;
    }

    public BaseEvent getBaseEvent() {
        return baseEvent;
    }

    public void setBaseEvent(BaseEvent baseEvent) {
        this.baseEvent = baseEvent;
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
