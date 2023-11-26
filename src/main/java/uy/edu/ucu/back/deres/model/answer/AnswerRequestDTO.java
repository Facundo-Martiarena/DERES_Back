package uy.edu.ucu.back.deres.model.answer;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnswerRequestDTO {
    private Boolean answer;
    @JsonProperty("question_id")
    private Long questionID;

    public AnswerRequestDTO() {
    }
}
