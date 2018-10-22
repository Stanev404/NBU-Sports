package com.nbu.sportapp.nbusportapp.controller;

import com.nbu.sportapp.nbusportapp.dao.UserDAO;
import com.nbu.sportapp.nbusportapp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sportapp")
public class UserController {

    @Autowired
    UserDAO userDAO;

    /* to save an user*/
    @PostMapping("/users")
    public User createUser(@Valid @RequestBody User user){
        return this.userDAO.save(user);
    }

    /*get all users*/
    @GetMapping("/users")
    public List<User> getAllUsers(){
        return this.userDAO.findAll();
    }

    /*get an user by ID*/
    @GetMapping("/users/{id}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable(value ="id")Long userId){
        Optional<User> user = this.userDAO.findOne(userId);
        if(user == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(user);
    }

    /*update an user*/
    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long userId,@Valid @RequestBody User userDetails){
        Optional<User> user = this.userDAO.findOne(userId);
        if(user==null){
            return ResponseEntity.notFound().build();
        }
        user.get().setFullName(userDetails.getFullName());
        user.get().setEmail(userDetails.getEmail());
        user.get().setPassword(userDetails.getPassword());

        User updateUser = this.userDAO.save(user.get());
        return ResponseEntity.ok().body(updateUser);

    }

    /*delete an user*/
    @DeleteMapping("/users/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable(value = "id") Long userId){

        Optional<User> user = this.userDAO.findOne(userId);
        if(user==null){
            return ResponseEntity.notFound().build();
        }
        this.userDAO.delete(user.get());

        return ResponseEntity.ok().build();
    }

}
