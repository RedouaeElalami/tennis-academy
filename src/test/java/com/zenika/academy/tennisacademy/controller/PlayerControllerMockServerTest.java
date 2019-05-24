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

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentCaptor.forClass;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
//@WebMvcTest(value = PlayerController.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PlayerControllerMockServerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PlayerJpaRepository playerJpaRepository;

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
        assertThat(playerArgumentCaptor.getValue().getName()).isEqualTo("titi");

    }

    @Test
    public void should_add_a_player_Zekrom() throws Exception {

        // GIVEN
        Player player = new Player();
        player.setName("titi");
        player.setAge(28);

        byte[] playerAsJson = objectMapper.writeValueAsBytes(player);


        mockMvc.perform(post("/ajouterJoueur").param("name", "titi").param("age", "28")).andExpect(redirectedUrl("/players")).andDo(print());
        List<Player> mockAll = playerJpaRepository.findAll();
        assertThat(mockAll).hasSize(6);
        assertThat(mockAll.get(5).getName()).isEqualTo("titi");
    }

    @Test
    public void should_get_all_players() throws Exception {

        //GIVEN..?

        //WHEN & THEN
        mockMvc.perform(get("/players"))
                .andExpect(content().string("[{\"id\":1,\"name\":\"Novak Djokovic\",\"age\":31},{\"id\":2,\"name\":\"Rafael Nadal\",\"age\":32},{\"id\":3,\"name\":\"Roger Federer\",\"age\":32},{\"id\":4,\"name\":\"Alexander Zverev\",\"age\":21},{\"id\":5,\"name\":\"Juan Martin del Potro\",\"age\":30}]"));

    }

}
