package com.zenika.academy.tennisacademy.controller;

import com.zenika.academy.tennisacademy.TennisAcademyApplication;
import com.zenika.academy.tennisacademy.domain.Player;
import com.zenika.academy.tennisacademy.repository.PlayerJpaRepository;
import com.zenika.academy.tennisacademy.repository.PlayerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TennisAcademyApplication.class
        , webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PlayerControlNoToDoTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private PlayerRepository playerJpaRepositoryMock;

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
        verify(playerJpaRepositoryMock).save(any(Player.class));

    }

}

