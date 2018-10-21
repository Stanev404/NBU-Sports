package com.nbu.sportapp.nbusportapp.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;

/**
 * A user is a person who is in the website session.
 */

@Entity
@Table(name = "users_table")
public class User extends BaseEntity implements UserDetails {
    @Column
    private String fullName;

    @Column
    private String email;

    @Column
    private String password;

    @Transient
    private Set<GrantedAuthority> authorities;

    public User() {
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

    public User(String fullName, String email, String password) {
        super();
        this.fullName = fullName;
        this.email = email;
        this.password = password;
    }

    public void setEmail(String email) throws IllegalArgumentException {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.email = email;
    }


    @Override
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        if (password == null || password.isEmpty()) {
            this.password = password;
        }
        throw new IllegalArgumentException();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

}