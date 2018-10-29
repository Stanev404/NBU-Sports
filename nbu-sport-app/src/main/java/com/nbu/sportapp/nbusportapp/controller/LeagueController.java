package com.nbu.sportapp.nbusportapp.controller;

import com.nbu.sportapp.nbusportapp.dao.LeagueDAO;
import com.nbu.sportapp.nbusportapp.entity.League;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/sportapp")
public class LeagueController {

    @Autowired
    LeagueDAO leagueDAO;

    /* to save an league*/
    @PostMapping("/league")
    public League createLeague(@Valid @RequestBody League league) {
        return this.leagueDAO.save(league);
    }

    /*get all leagues*/
    @GetMapping("/leagues")
    public List<League> getAllLeagues() {
        return this.leagueDAO.findAll();
    }

    /*get an league by ID*/
    @GetMapping("/leagues/{id}")
    public ResponseEntity<League> getLeagueById(@PathVariable(value = "id") Long leagueId) {
        League league = this.leagueDAO.findOne(leagueId);
        if (league == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(league);
    }

    /*update an league*/
    @PutMapping("/leagues/{id}")
    public ResponseEntity<League> updateLeague(@PathVariable(value = "id") Long leagueId, @Valid @RequestBody League leagueDetails) {
        League league = this.leagueDAO.findOne(leagueId);
        if (league == null) {
            return ResponseEntity.notFound().build();
        }

        league.setName(leagueDetails.getName());
        League updateLeague = this.leagueDAO.save(league);
        return ResponseEntity.ok().body(updateLeague);

    }

    /*delete an league*/
    @DeleteMapping("/leagues/{id}")
    public ResponseEntity<League> deleteLeague(@PathVariable(value = "id") Long leagueId) {

        League league = this.leagueDAO.findOne(leagueId);
        if (league == null) {
            return ResponseEntity.notFound().build();
        }
        this.leagueDAO.delete(league);

        return ResponseEntity.ok().build();
    }

}