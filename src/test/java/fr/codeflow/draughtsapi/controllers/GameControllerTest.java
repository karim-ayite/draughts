package fr.codeflow.draughtsapi.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.codeflow.draughtsapi.model.NewGameRequest;
import fr.codeflow.draughtsapi.model.PieceColors;
import fr.codeflow.draughtsapi.model.Player;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class GameControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void should_return_a_new_game() throws Exception {
        var aNewGame = new NewGameRequest();

        var player1 = new Player();
        player1.setUsername("duke");
        player1.setPieceColor(PieceColors.DARK);
        aNewGame.setPlayer1(player1);

        var player2 = new Player();
        player2.setUsername("nukem");
        player2.setPieceColor(PieceColors.LIGHT);
        aNewGame.setPlayer2(player2);

        this.mockMvc.perform(post("/games")
                        .content(asJsonString(aNewGame))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.player1.username").value("duke"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.player2.username").value("nukem"));
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}