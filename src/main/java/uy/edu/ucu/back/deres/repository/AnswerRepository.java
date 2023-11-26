package uy.edu.ucu.back.deres.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uy.edu.ucu.back.deres.entity.Answer;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {

    @Query(value = "SELECT * FROM answer WHERE provider_rut = ?1", nativeQuery = true)
    List<Answer> findByProviderRut(String providerRut);
}
