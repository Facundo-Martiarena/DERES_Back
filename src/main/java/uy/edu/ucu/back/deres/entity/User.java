package uy.edu.ucu.back.deres.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Builder
@AllArgsConstructor
public class User {
    @Id
    private UUID id;
    private String name;
    private String password;
    private Privilege privilege;


    public User() {

    }
}
