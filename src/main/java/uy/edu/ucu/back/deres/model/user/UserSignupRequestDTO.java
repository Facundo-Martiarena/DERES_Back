package uy.edu.ucu.back.deres.model.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
public class UserSignupRequestDTO {
    private String name;
    private String password;
    private Privilege privilege;
    private UUID id;
    private String email;
}
