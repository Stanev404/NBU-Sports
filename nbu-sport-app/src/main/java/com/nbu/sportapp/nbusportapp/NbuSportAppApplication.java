package com.nbu.sportapp.nbusportapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Date;

@SpringBootApplication
@EnableJpaAuditing
public class NbuSportAppApplication {

    public static void main(String[] args) {
        System.out.println(new Date().toString());

        SpringApplication.run(NbuSportAppApplication.class, args);


    }
}
