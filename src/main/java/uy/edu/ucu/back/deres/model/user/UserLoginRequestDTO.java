package uy.edu.ucu.back.deres.model.user;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserLoginRequestDTO {
    private String name;
    private String password;
    private String email;
}
