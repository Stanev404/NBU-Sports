package com.nbu.sportapp.nbusportapp;

import com.nbu.sportapp.nbusportapp.entity.User;
import com.nbu.sportapp.nbusportapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class UserServiceCommandLineRunner implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Override
    public void run(String... arg0) throws Exception{
        User testUser = new User("Ivan Stanev","rey_97@abv.bg","123456");
        String insert = this.userService.insert(testUser);
    }
}
