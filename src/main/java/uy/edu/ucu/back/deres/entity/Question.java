package uy.edu.ucu.back.deres.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import uy.edu.ucu.back.deres.model.question.QuestionType;

import java.util.UUID;

@Entity
@Data
@Builder
@AllArgsConstructor
@Table(name = "question")
public class Question {

    @Id
    private UUID id;
    private String question;
    private QuestionType type;


    public Question() {
    }
}
