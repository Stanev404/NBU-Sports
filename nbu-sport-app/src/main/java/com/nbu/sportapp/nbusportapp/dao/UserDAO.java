package com.nbu.sportapp.nbusportapp.dao;

import com.nbu.sportapp.nbusportapp.entity.User;
import com.nbu.sportapp.nbusportapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// DATA ACCESS OBJECT
@Service
public class UserDAO {

    @Autowired
    UserRepository userRepository;

    /*to save an user in DB*/

    public User save(User user){
        return this.userRepository.save(user);
    }

    /*search all users*/

    public List<User> findAll(){
        return this.userRepository.findAll();
    }

    /*get an user*/

    public User findOne(Long userId){
        return this.userRepository.findOne(userId);
    }

    /*delete an user*/

    public void delete(User user){
        this.userRepository.delete(user);
    }
}
