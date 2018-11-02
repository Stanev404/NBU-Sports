package com.nbu.sportapp.nbusportapp.dao;

import com.nbu.sportapp.nbusportapp.entity.Team;
import com.nbu.sportapp.nbusportapp.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// DATA ACCESS OBJECT
@Service
public class TeamDAO {

    @Autowired
    TeamRepository teamRepository;

    /*to save an user in DB*/

    public Team save(Team team) {
        return this.teamRepository.save(team);
    }

    /*search all users*/

    public List<Team> findAll() {
        return this.teamRepository.findAll();
    }

    /*get an user*/

    public Team findOne(Long teamId) {
        return this.teamRepository.findOne(teamId);
    }

    /*delete an user*/

    public void delete(Team team) {
        this.teamRepository.delete(team);
    }
}