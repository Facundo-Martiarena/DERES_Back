package uy.edu.ucu.back.deres.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Builder
@AllArgsConstructor
@Table(name = "provider")
public class Provider {
    @Id
    private UUID id;
    private String name;
    private String RUT;
    private String type;
    private String score;

    public Provider() {
    }
}
