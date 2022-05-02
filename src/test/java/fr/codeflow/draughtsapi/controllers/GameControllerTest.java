package fr.codeflow.draughtsapi.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.codeflow.draughtsapi.JSonUtils;
import fr.codeflow.draughtsapi.model.DraughtsRules;
import fr.codeflow.draughtsapi.model.NewGameRequest;
import fr.codeflow.draughtsapi.model.PiecesColors;
import fr.codeflow.draughtsapi.model.Player;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class GameControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void Should_ReturnGame_When_RequestIsValid() throws Exception {
        var aNewGame = new NewGameRequest();

        var player1 = new Player();
        player1.setUsername("duke");
        player1.setPiecesColors(PiecesColors.DARK);
        aNewGame.setPlayer1(player1);

        var player2 = new Player();
        player2.setUsername("nukem");
        player2.setPiecesColors(PiecesColors.LIGHT);
        aNewGame.setPlayer2(player2);

        aNewGame.setRules(DraughtsRules.INTERNATIONAL);

        this.mockMvc.perform(post("/games")
                        .content(JSonUtils.asJsonString(aNewGame))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.player1.username").value("duke"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.player1.piecesColors").value("DARK"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.player2.username").value("nukem"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.player2.piecesColors").value("LIGHT"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.board.squares").exists());
    }

    @Test
    public void Should_ReturnValidationError_When_NewGameRequestIsEmpty() throws Exception {
        var aNewGame = new NewGameRequest();

        this.mockMvc.perform(post("/games")
                        .content(JSonUtils.asJsonString(aNewGame))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.subErrors[?(@.field == 'rules')]").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.subErrors[?(@.field == 'rules')].object").value("newGameRequest"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.subErrors[?(@.field == 'rules')].rejectedValue").value(IsNull.nullValue()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.subErrors[?(@.field == 'player2')]").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.subErrors[?(@.field == 'player2')].object").value("newGameRequest"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.subErrors[?(@.field == 'player1')]").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.subErrors[?(@.field == 'player1')].object").value("newGameRequest"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.subErrors[?(@.field == 'rules')].rejectedValue").value("rules"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.subErrors[0].rejectedValue").value("null"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.subErrors[1].object").value("newGameRequest"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.subErrors[1].field").value("player2"))
                ;

    }


}