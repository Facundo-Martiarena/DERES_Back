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
@Table(name = "user")
public class User {
    @Id
    private String username;
    private String password;
    private String privilege;

    public User() {

    }
}
