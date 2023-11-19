package uy.edu.ucu.back.deres.model.user;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

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
