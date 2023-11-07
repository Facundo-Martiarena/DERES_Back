package uy.edu.ucu.back.deres.model.question;

import lombok.Data;

import java.util.List;

@Data
public class QuestionsRequestDTO {

    private List<QuestionRequestDTO> questions;
}
