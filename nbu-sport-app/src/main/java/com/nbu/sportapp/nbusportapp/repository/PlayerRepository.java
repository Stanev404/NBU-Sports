package com.nbu.sportapp.nbusportapp.repository;

import com.nbu.sportapp.nbusportapp.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
