package uy.edu.ucu.back.deres.model.user;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;
import uy.edu.ucu.back.deres.model.Privilege;

@Setter
@Getter
public class UserSignupRequestDTO {
    private String name;
    private String password;
    private Privilege privilege;
    private UUID id;
}
