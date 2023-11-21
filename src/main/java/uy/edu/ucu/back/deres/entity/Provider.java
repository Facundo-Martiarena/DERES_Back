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
@Table(name = "provider")
public class Provider {
    @Id
    private String name;
    private String rut;
    private String address;
    private String phone;
    private String email;
    private String type;
    private String score;

    public Provider() {
    }
}
