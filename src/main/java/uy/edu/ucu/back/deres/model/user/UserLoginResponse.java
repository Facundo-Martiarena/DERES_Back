package uy.edu.ucu.back.deres.model.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserLoginResponse {

    private Boolean accepted;
    private String privilege;
    private String providerID;
}
