package uy.edu.ucu.back.deres.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uy.edu.ucu.back.deres.entity.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

    //actializar pregunta
    @Query(value = "UPDATE question SET question = ?1, type = ?2, ponderation = ?3 WHERE id = ?4", nativeQuery = true)
    void updateQuestion(String question, String type, String ponderation, Long id);

}
