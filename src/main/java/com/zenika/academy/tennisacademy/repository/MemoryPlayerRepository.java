package com.zenika.academy.tennisacademy.repository;

import com.zenika.academy.tennisacademy.domain.Player;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Profile("dev")
@Repository
public class MemoryPlayerRepository implements PlayerRepository{

    private List<Player> players = new ArrayList<>();

    @Override
    public List<Player> findAll() {
        return new ArrayList<>(players);
    }

    @Override
    public Optional<Player> findById(Long id) {
        return   players.stream()
                .filter(player -> player.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Player> findByAge(Integer age) {
       return    players.stream()
                .filter(player -> age.equals(player.getAge()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Player> findByName(String name) {
        return   players.stream()
                .filter(player -> player.getName().equals(name))
                .collect(Collectors.toList());
    }

    @Override
    public Player save(Player player) {
        players.add(player);
        return player;
    }
}
