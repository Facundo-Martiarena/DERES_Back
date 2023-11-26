package uy.edu.ucu.back.deres.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
@AllArgsConstructor
@Table(name = "answer")
public class Answer {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private Boolean answer;
    @Column(name = "question_id")
    private Long questionID;
    @Column(name = "provider_rut")
    private String providerRut;
}
