package com.zenika.academy.tennisacademy.repository;

import com.zenika.academy.tennisacademy.domain.Player;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Profile("!dev")
//@Profile("prod")
@Repository
public interface PlayerJpaRepository extends PlayerRepository, JpaRepository<Player, Long> {


    @Query("FROM Player p WHERE p.age = :age")
    List<Player> findPlayersByAge(@Param("age") Integer age);

    List<Player> findByAge(Integer age);

    List<Player> findByName(String name);
}
