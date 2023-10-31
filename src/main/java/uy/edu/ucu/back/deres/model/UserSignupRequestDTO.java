package uy.edu.ucu.back.deres.model;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserSignupRequestDTO {
    private String name;
    private String password;
    private Privilege privilege;
    private UUID id;
}
