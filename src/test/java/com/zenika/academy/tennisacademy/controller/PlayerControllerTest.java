package com.zenika.academy.tennisacademy.controller;

import com.zenika.academy.tennisacademy.TennisAcademyApplication;
import com.zenika.academy.tennisacademy.domain.Player;
import com.zenika.academy.tennisacademy.repository.PlayerJpaRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TennisAcademyApplication.class
        , webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PlayerControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private PlayerJpaRepository playerJpaRepository;

    @Test
    public void should_find_one_player() {

        // GIVEN
        String getUrl = "http://localhost:" + port + "/players/1";

        // WHEN
        final ResponseEntity<Player> playerResponseEntity
                = restTemplate.getForEntity(getUrl, Player.class);
        final Player resultingPlayer = playerResponseEntity.getBody();

        // THEN
        assertThat(playerResponseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(resultingPlayer.getName()).isEqualTo("Novak Djokovic");
        assertThat(resultingPlayer.getAge()).isEqualTo(31);
    }

    @Test
    public void should_find_all_players() {

        // GIVEN
        String getUrl = "http://localhost:" + port + "/players";

        // WHEN
        final ResponseEntity<List> listPlayerResponseEntity = restTemplate.getForEntity(getUrl, List.class);
        final List<Player> resultingPlayerList = listPlayerResponseEntity.getBody();

        // THEN
        assertThat(listPlayerResponseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(resultingPlayerList).hasSize(5);
        assertThat(resultingPlayerList).extracting("name", "age")
                .containsExactly(tuple("Novak Djokovic", 31),
                        tuple("Rafael Nadal", 32),
                        tuple("Roger Federer", 32),
                        tuple("Alexander Zverev", 21),
                        tuple("Juan Martin del Potro", 30));
    }


    @Test
    public void should_add_a_player() {

        // GIVEN
        String postUrl = "http://localhost:" + port + "/ajouterJoueur";

        // WHEN
        Player player = new Player();
        player.setName("titi");
        player.setAge(28);

        restTemplate.postForEntity(postUrl, player, Player.class);

        // THEN
        List<Player> players = playerJpaRepository.findByName("titi");
        assertThat(players).hasSize(1);
        Player titiPlayer = players.get(0);
        assertThat(titiPlayer.getAge()).isEqualTo(28);
        assertThat(titiPlayer.getId()).isNotNull();

    }

}