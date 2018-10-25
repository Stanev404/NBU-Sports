package com.nbu.sportapp.nbusportapp.entity;


import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * A user with special privileges.
 */

@Entity
@Table(name = "admins")
@EntityListeners(AuditingEntityListener.class)
public class Admin extends BaseEntity {
    @NotBlank
    private String fullName;

    @NotBlank
    private String email;

    @NotBlank
    private String password;


    public Admin() {
    }

    public Admin(String fullName, String email, String password) {
        super();
        this.fullName = fullName;
        this.email = email;
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws IllegalArgumentException {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}