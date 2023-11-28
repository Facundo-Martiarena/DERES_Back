package uy.edu.ucu.back.deres.model.provider;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProviderResponseDTO {


    private Boolean accepted;
    @JsonProperty("provider_id")
    private String providerID;
}
