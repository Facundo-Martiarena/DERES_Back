package uy.edu.ucu.back.deres.model.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class UserLoginRequestDTO {
    private String name;
    private String password;
    private String email;
}
