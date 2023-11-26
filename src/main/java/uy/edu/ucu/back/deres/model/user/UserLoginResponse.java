package uy.edu.ucu.back.deres.model.user;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserLoginResponse {

    private Boolean accepted;
    private String privilege;
    @JsonProperty("provider_id")
    private String providerID;
}
