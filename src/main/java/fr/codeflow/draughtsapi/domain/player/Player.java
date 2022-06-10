package fr.codeflow.draughtsapi.domain.player;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Document
@Data
public class Player {

    @Id
    private String id;

    @Size(max = 50)
    private String lastname;

    @Size(max = 50)
    private String firstname;

    @Size(max = 8)
    private String password;

    @NotBlank
    @Size(max = 50)
    private String nickname;

    @Email
    private String email;

}
