package uy.edu.ucu.back.deres.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class User {
    @Id
    private UUID id;
    private String name;
    private String lastName;
    private String password;

    public User() {
        this.id = UUID.randomUUID();
    }
}
