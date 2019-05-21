package com.zenika.academy.tennisacademy.repository;

import com.zenika.academy.tennisacademy.domain.Player;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PlayerRepository {

    List<Player> findAll();

    Optional<Player> findById(Long id);

    List<Player> findByAge(Integer age);

    List<Player> findByName(String name);

    Player save(Player player);
}



