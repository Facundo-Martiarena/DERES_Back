package uy.edu.ucu.back.deres.model.question;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class QuestionRequestDTO {

    @JsonIgnore
    private Long id;
    private String question;
    private String ponderation;
    private QuestionType type;

    public QuestionRequestDTO() {
    }
}
