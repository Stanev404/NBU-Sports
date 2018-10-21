package com.nbu.sportapp.nbusportapp.service;

import com.nbu.sportapp.nbusportapp.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class UserService {

    @PersistenceContext
    private EntityManager entityManager;

    public String insert(User user){
        this.entityManager.persist(user);
        return user.getId();
    }
}
