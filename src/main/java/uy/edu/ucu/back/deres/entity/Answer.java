package uy.edu.ucu.back.deres.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    private Long questionID;
    private String providerRut;
}
