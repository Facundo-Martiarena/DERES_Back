package uy.edu.ucu.back.deres.model.user;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    private String email;
    @JsonProperty("provider_id")
    private String providerID;
}
