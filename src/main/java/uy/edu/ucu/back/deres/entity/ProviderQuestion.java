package uy.edu.ucu.back.deres.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
@AllArgsConstructor
@Table(name = "provider_question")
public class ProviderQuestion {

    @Id
    private Long id;
    private Long providerId;
    private Long questionId;

    public ProviderQuestion() {
    }
}
