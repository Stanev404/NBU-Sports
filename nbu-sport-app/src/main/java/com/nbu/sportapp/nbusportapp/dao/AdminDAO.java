package com.nbu.sportapp.nbusportapp.dao;

import com.nbu.sportapp.nbusportapp.entity.user.Admin;
import com.nbu.sportapp.nbusportapp.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// DATA ACCESS OBJECT
@Service
public class AdminDAO {

    @Autowired
    private AdminRepository AdminRepository;

    /*to save an user in DB*/

    public Admin save(Admin admin){
        return this.AdminRepository.save(admin);
    }

    /*search all users*/

    public List<Admin> findAll(){
        return this.AdminRepository.findAll();
    }

    /*get an user*/

    public Admin findOne(Long adminId){
        return this.AdminRepository.findOne(adminId);
    }

    /*delete an user*/

    public void delete(Admin admin){
        this.AdminRepository.delete(admin);
    }
}
