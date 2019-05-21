package com.zenika.academy.tennisacademy.controller;

import com.zenika.academy.tennisacademy.domain.Player;
import com.zenika.academy.tennisacademy.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping("/players")
    public List<Player> findAll() {
        return playerService.findAll();
    }

    @GetMapping("/players/{id}")
    public Player findPlayer(@PathVariable("id") Long id) {
        return playerService.findPlayerById(id);
    }

    @GetMapping("/players/id")
    public Player findPlayerURL(@RequestParam Long id){
//        http://localhost:8080//players/id?id=1
        return playerService.findPlayerById(id);
    }

    @GetMapping("/players/age/{age}")
    public List<Player> findPlayersByAge(@PathVariable("age") Integer age) {
        return playerService.findPlayersByAge(age);
    }

    @GetMapping("/players/name/{name}")
    public List<Player> findPlayersByName(@PathVariable("name") String name) {
        return playerService.findPlayersByName(name);
    }


    @PostMapping("/ajouterJoueur")
    public RedirectView createPlayer(@RequestBody Player player) {
        playerService.save(player);
        return new RedirectView("/players");
    }

    @GetMapping("/modifier/{id}")
    public Player test(@PathVariable("id") Long id) {
        return null;
    }

    @PostMapping("/modifierJoueur")
    public RedirectView updatePlayer(@RequestBody Player player) {
        playerService.save(player);
        return new RedirectView("/players");
    }

}
