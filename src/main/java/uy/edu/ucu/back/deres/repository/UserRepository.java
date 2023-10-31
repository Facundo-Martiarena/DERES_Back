package uy.edu.ucu.back.deres.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uy.edu.ucu.back.deres.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
