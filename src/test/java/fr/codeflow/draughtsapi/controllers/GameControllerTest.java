package fr.codeflow.draughtsapi.controllers;

import fr.codeflow.draughtsapi.domain.game.Game;
import fr.codeflow.draughtsapi.domain.game.GameStatus;
import fr.codeflow.draughtsapi.domain.game.PiecesColor;
import fr.codeflow.draughtsapi.payload.request.CreateGameRequest;
import fr.codeflow.draughtsapi.repositories.GameRepository;
import fr.codeflow.draughtsapi.utils.JSonUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
@Testcontainers
class GameControllerTest {

    private final MockMvc mockMvc;

    @Container
    public static MongoDBContainer mongoDBContainer = new MongoDBContainer();

    public GameControllerTest( @Autowired MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @DynamicPropertySource
    static void mongoDbProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
    }

    private String validCreateRequestAsJson;

    @Autowired
    private GameRepository gameRepository;

    @BeforeEach
    private void setUp(){
        CreateGameRequest validCreateGameRequest = new CreateGameRequest("88", PiecesColor.DARK,null);
        validCreateRequestAsJson = JSonUtils.asJsonString(validCreateGameRequest);
    }

    @Test
    @DisplayName("Should create a game")
    void shouldCreateAGame() throws Exception {
        mockMvc.perform(post("/api/games/").contentType(MediaType.APPLICATION_JSON).content(validCreateRequestAsJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.player1Id").value("88"))
                .andExpect(jsonPath("$.status").value(GameStatus.WAITING_FOR_PLAYER.name()))
                .andExpect(jsonPath("$.player1PiecesColor").value(PiecesColor.DARK.name()));
    }

    @Test
    @DisplayName("Should Return games in status WAITING_FOR_PLAYER")
    void shouldReturnGamesInStatusWaitingForPlayer() throws Exception {
        gameRepository.saveAll(createGames());
        mockMvc.perform(get("/api/games?status=WAITING_FOR_PLAYER"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[*]",hasSize(2)));
    }

    private List<Game> createGames() {
        var games = new ArrayList<Game>();
        var newGame = new Game();
        newGame.setCreationDate(LocalDateTime.now());
        newGame.setPlayer1Id("11");
        newGame.setPlayer1PiecesColor(PiecesColor.DARK);
        newGame.setStatus(GameStatus.WAITING_FOR_PLAYER);
        games.add(newGame);

        newGame = new Game();
        newGame.setCreationDate(LocalDateTime.now());
        newGame.setPlayer1Id("11");
        newGame.setPlayer1PiecesColor(PiecesColor.DARK);
        newGame.setStatus(GameStatus.WAITING_FOR_PLAYER);
        games.add(newGame);

        return games;

    }

}