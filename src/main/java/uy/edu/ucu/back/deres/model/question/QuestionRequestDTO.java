package uy.edu.ucu.back.deres.model.question;


import lombok.Data;

@Data
public class QuestionRequestDTO {
    private String question;
    private QuestionType type;

    public QuestionRequestDTO() {
    }
}