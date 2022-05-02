package fr.codeflow.draughtsapi.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class Player {

    @NotNull
    @NotBlank
    private String username;

    @NotNull
    private PiecesColors piecesColors;
}
