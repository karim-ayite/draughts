package fr.codeflow.draughtsapi.payload.request;

import fr.codeflow.draughtsapi.domain.game.PiecesColor;
import fr.codeflow.draughtsapi.validator.CheckAtLeastOneNotNull;

import javax.validation.constraints.NotNull;

@CheckAtLeastOneNotNull(fieldNames = {"playerId","nickname"})
public record CreateGameRequest(String playerId,@NotNull PiecesColor playerColor,String nickname) {
}
