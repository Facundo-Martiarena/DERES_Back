package uy.edu.ucu.back.deres.model.provider;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProviderRequestDTO {

    private String name;
    @JsonProperty("rut")
    private String RUT;
    private String type;
    private String score;

    public ProviderRequestDTO() {
    }
}
