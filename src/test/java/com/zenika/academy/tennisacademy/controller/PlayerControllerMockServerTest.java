package com.zenika.academy.tennisacademy.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zenika.academy.tennisacademy.domain.Player;
import com.zenika.academy.tennisacademy.repository.PlayerJpaRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentCaptor.forClass;

@RunWith(SpringRunner.class)
//@WebMvcTest(value = PlayerController.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PlayerControllerMockServerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PlayerJpaRepository playerJpaRepositoryMock;

    //@MockBean
    //private EntityManager em;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void should_add_a_player() throws Exception {

        // GIVEN
        String postUrl = "/ajouterJoueur";

        Player player = new Player();
        player.setName("titi");
        player.setAge(28);

        // WHEN
        byte[] playerAsJson = objectMapper.writeValueAsBytes(player);

        RequestBuilder requestBuilder =
                MockMvcRequestBuilders
                        .post(postUrl)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(playerAsJson)
                        .contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder);

        // THEN
        ArgumentCaptor<Player> playerArgumentCaptor = forClass(Player.class);
         Player savedPlayer = playerArgumentCaptor.getValue();
        assertThat(savedPlayer.getName()).isEqualTo("titi");

    }

}
