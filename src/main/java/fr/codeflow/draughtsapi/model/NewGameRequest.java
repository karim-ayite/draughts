package fr.codeflow.draughtsapi.model;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
public class NewGameRequest {

     @NotNull
     @Valid
     private Player player1;

     @NotNull
     @Valid
     private Player player2;

}
