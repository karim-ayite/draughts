package fr.codeflow.draughtsapi.model;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class Player {

    @NotNull
    @NotEmpty
    private String username;

    @NotNull
    private PiecesColors piecesColors;
}
