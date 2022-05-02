package fr.codeflow.draughtsapi.model;

import lombok.Data;

@Data
public class NewGameRequest {
     private Player player1;

     private Player player2;

     DraughtsRules rules;
}
