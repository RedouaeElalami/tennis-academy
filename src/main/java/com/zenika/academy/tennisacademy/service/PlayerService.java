package com.zenika.academy.tennisacademy.service;

import com.zenika.academy.tennisacademy.domain.Player;
import com.zenika.academy.tennisacademy.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    //@Autowired
    //private HibernatePlayerRepository hibernatePlayerRepository;

    public List<Player> findAll() {
        return this.playerRepository.findAll();
        //throw new IllegalStateException("Noooon !");
    }

    public Player findPlayerById(Long id) {
        final Optional<Player> optionalPlayer = playerRepository.findById(id);
        return optionalPlayer.orElse(new Player());
    }

    public List<Player> findPlayersByAge(Integer age) {
//        return playerRepository.findPlayersByAge(age);
        return playerRepository.findByAge(age);
//        return hibernatePlayerRepository.findPlayersByAge(age);
    }

    public List<Player> findPlayersByName(String name) {
        return playerRepository.findByName(name);
    }


    @Value("${mon.nom}")
    private String monNom;

    @Transactional
    public void save(Player player) {
        final Player savedPlayer = playerRepository.save(player);
       //System.out.println("savedPlayer = " + savedPlayer);
    }

}
