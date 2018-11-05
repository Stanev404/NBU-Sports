package com.nbu.sportapp.nbusportapp.repository;

import com.nbu.sportapp.nbusportapp.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
