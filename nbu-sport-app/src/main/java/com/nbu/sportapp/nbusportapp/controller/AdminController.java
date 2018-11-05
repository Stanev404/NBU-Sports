package com.nbu.sportapp.nbusportapp.controller;

import com.nbu.sportapp.nbusportapp.dao.AdminDAO;
import com.nbu.sportapp.nbusportapp.entity.user.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/sportapp")
public class AdminController {

    @Autowired
    AdminDAO adminDAO;

    /* to save an admin*/
    @PostMapping("/admin")
    public Admin createAdmin(@Valid @RequestBody Admin admin){
        return this.adminDAO.save(admin);
    }

    /*get all admins*/
    @GetMapping("/admins")
    public List<Admin> getAllAdmins(){
        return this.adminDAO.findAll();
    }

    /*get an admin by ID*/
    @GetMapping("/admins/{id}")
    public ResponseEntity<Admin> getAdminById(@PathVariable(value ="id")Long adminId){
        Admin admin = this.adminDAO.findOne(adminId);
        if(admin == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(admin);
    }

    /*update an admin*/
    @PutMapping("/admins/{id}")
    public ResponseEntity<Admin> updateAdmin(@PathVariable(value = "id") Long adminId,@Valid @RequestBody Admin adminDetails){
        Admin admin = this.adminDAO.findOne(adminId);
        if(admin==null){
            return ResponseEntity.notFound().build();
        }
        admin.setFullName(adminDetails.getFullName());
        admin.setEmail(adminDetails.getEmail());
        admin.setPassword(adminDetails.getPassword());

        Admin updateAdmin = this.adminDAO.save(admin);
        return ResponseEntity.ok().body(updateAdmin);

    }

    /*delete an admin*/
    @DeleteMapping("/admins/{id}")
    public ResponseEntity<Admin> deleteAdmin(@PathVariable(value = "id") Long adminId){

        Admin admin = this.adminDAO.findOne(adminId);
        if(admin==null){
            return ResponseEntity.notFound().build();
        }
        this.adminDAO.delete(admin);

        return ResponseEntity.ok().build();
    }

}