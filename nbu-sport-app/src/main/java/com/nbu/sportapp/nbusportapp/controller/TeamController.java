package com.nbu.sportapp.nbusportapp.controller;

import com.nbu.sportapp.nbusportapp.dao.TeamDAO;
import com.nbu.sportapp.nbusportapp.entity.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/sportapp")
public class TeamController {

    @Autowired
    TeamDAO teamDAO;

    /* to save an team*/
    @PostMapping("/team")
    public Team createTeam(@Valid @RequestBody Team team) {
        return this.teamDAO.save(team);
    }

    /*get all teams*/
    @GetMapping("/teams")
    public List<Team> getAllTeams() {
        return this.teamDAO.findAll();
    }

    /*get an team by ID*/
    @GetMapping("/teams/{id}")
    public ResponseEntity<Team> getTeamById(@PathVariable(value = "id") Long teamId) {
        Team team = this.teamDAO.findOne(teamId);
        if (team == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(team);
    }

    /*update an team*/
    @PutMapping("/teams/{id}")
    public ResponseEntity<Team> updateTeam(@PathVariable(value = "id") Long teamId, @Valid @RequestBody Team teamDetails) {
        Team team = this.teamDAO.findOne(teamId);
        if (team == null) {
            return ResponseEntity.notFound().build();
        }

        team.setName(teamDetails.getName());
        Team updateTeam = this.teamDAO.save(team);
        return ResponseEntity.ok().body(updateTeam);

    }

    /*delete an team*/
    @DeleteMapping("/teams/{id}")
    public ResponseEntity<Team> deleteTeam(@PathVariable(value = "id") Long teamId) {

        Team team = this.teamDAO.findOne(teamId);
        if (team == null) {
            return ResponseEntity.notFound().build();
        }
        this.teamDAO.delete(team);

        return ResponseEntity.ok().build();
    }

}