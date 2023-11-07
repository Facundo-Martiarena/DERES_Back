package uy.edu.ucu.back.deres.model.provider;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProviderAddRequestDTO {

    private String name;
    private String RUT;
    private String type;
    private String score;

    public ProviderAddRequestDTO() {
    }
}
