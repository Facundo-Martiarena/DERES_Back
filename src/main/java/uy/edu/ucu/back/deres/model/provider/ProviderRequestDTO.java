package uy.edu.ucu.back.deres.model.provider;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProviderRequestDTO {

    @JsonProperty("rut")
    private String RUT;
    private String name;
    private String type;
    private String email;
    private String contact;
    private String phone;
    private String score;
    private String address;

    public ProviderRequestDTO() {
    }
}
