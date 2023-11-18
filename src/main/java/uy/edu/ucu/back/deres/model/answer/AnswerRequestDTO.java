package uy.edu.ucu.back.deres.model.answer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnswerRequestDTO {
    private Boolean answer;
    private Long questionID;
    private String providerRut;

    public AnswerRequestDTO() {
    }
}
