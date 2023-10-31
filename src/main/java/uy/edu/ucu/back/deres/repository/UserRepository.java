package uy.edu.ucu.back.deres.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uy.edu.ucu.back.deres.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
