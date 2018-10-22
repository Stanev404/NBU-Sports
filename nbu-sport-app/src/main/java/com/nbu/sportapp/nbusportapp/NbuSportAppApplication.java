package com.nbu.sportapp.nbusportapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication
@EnableJpaAuditing
public class NbuSportAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(NbuSportAppApplication.class, args);
//        String url = "jdbc:mysql://localhost:3307/world?verifyServerCertificate=false&useSSL=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"; // ?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
//        String username = "root";
//        String password = "123456";
//
//        System.out.println("Connecting database...");
//
//        try (Connection connection = DriverManager.getConnection(url, username, password)) {
//            System.out.println("Database connected!");
//        } catch (SQLException e) {
//            throw new IllegalStateException("Cannot connect the database!", e);
//        }

    }
}
