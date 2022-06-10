package fr.codeflow.draughtsapi.payload.request;

import fr.codeflow.draughtsapi.domain.game.PiecesColor;

import javax.validation.constraints.NotNull;

public record CreateGameRequest(String playerId,@NotNull PiecesColor playerColor,String nickname) {
}
