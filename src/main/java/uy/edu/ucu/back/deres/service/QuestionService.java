package uy.edu.ucu.back.deres.service;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uy.edu.ucu.back.deres.entity.Question;
import uy.edu.ucu.back.deres.model.ResponseOK;
import uy.edu.ucu.back.deres.model.question.QuestionRequestDTO;
import uy.edu.ucu.back.deres.repository.QuestionRepository;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public List<Question> getQuestions() {
        try {
            List<Question> questions = questionRepository.findAll();
            return questions;
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener preguntas de la base de datos.", e);
        }

    }

    public ResponseOK addQuestion(QuestionRequestDTO question) {
        try {
            var questionEntity = Question.builder()
                    .question(question.getQuestion())
                    .type(question.getType().toString().toUpperCase())
                    .build();
            questionRepository.save(questionEntity);
            return new ResponseOK(true);
        } catch (Exception e) {
            throw new RuntimeException("Error al agregar pregunta a la base de datos.", e);
        }

    }

}
