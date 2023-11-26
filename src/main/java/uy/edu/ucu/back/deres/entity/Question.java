package uy.edu.ucu.back.deres.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
@AllArgsConstructor
@Table(name = "question")
public class Question {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String question;
    private String type;
    private String ponderation;

    public Question() {
    }
}
