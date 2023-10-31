package uy.edu.ucu.back.deres.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class Provider {
    @Id
    private UUID id;
    private String name;
    private String RUT;
    private String type;
    private String score;

    public Provider() {
        this.id = UUID.randomUUID();
    }
}
