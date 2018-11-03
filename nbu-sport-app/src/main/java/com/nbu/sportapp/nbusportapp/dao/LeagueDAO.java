package com.nbu.sportapp.nbusportapp.dao;

import com.nbu.sportapp.nbusportapp.entity.League;
import com.nbu.sportapp.nbusportapp.entity.User;
import com.nbu.sportapp.nbusportapp.repository.LeagueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// DATA ACCESS OBJECT
@Service
public class LeagueDAO {

    @Autowired
    private LeagueRepository leagueRepository;

    /*to save an user in DB*/

    public League save(League league) {
        return this.leagueRepository.save(league);
    }

    /*search all users*/

    public List<League> findAll() {
        return this.leagueRepository.findAll();
    }

    /*get an user*/

    public League findOne(Long userId) {
        return this.leagueRepository.findOne(userId);
    }

    /*delete an user*/

    public void delete(League league) {
        this.leagueRepository.delete(league);
    }
}
