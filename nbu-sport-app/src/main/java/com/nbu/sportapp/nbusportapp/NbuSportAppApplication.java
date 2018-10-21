package com.nbu.sportapp.nbusportapp;

import com.nbu.sportapp.nbusportapp.entity.User;
import com.nbu.sportapp.nbusportapp.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@SpringBootApplication
public class NbuSportAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(NbuSportAppApplication.class, args);
//        //UserService userService = new UserService();
//        User ivan = new User("Ivan Stanev","rey_97@abv.bg","123456");
//        //String res = userService.insert(ivan);
//
//        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        entityManager.getTransaction().begin();
//
//        entityManager.persist(ivan);
//        entityManager.getTransaction().commit();
//
//        entityManagerFactory.close();

    }
}
