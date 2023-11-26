package uy.edu.ucu.back.deres.model.answer;

import lombok.Data;

import java.util.List;

@Data
public class AnswersRequestDTO {

    private List<AnswerRequestDTO> questions;
}
