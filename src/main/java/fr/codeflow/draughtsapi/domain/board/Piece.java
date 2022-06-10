package fr.codeflow.draughtsapi.domain.board;

import fr.codeflow.draughtsapi.domain.game.PiecesColor;
import lombok.Data;

@Data
public class Piece {
    private PiecesColor color;
    private boolean king;

    public boolean isLightColor(){
        return PiecesColor.LIGHT == this.color;
    }

}
