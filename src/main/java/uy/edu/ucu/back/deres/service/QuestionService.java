package uy.edu.ucu.back.deres.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uy.edu.ucu.back.deres.entity.Question;
import uy.edu.ucu.back.deres.model.ResponseOK;
import uy.edu.ucu.back.deres.model.question.QuestionRequestDTO;
import uy.edu.ucu.back.deres.model.question.QuestionsRequestDTO;
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

    public ResponseOK addQuestion(QuestionsRequestDTO questions) {
        try{
            for (QuestionRequestDTO question : questions.getQuestions()) {
                var questionEntity = Question.builder()
                        .question(question.getQuestion())
                        .type(question.getType().toString().toUpperCase())
                        .ponderation(question.getPonderation())
                        .build();
                questionRepository.save(questionEntity);
            }
            return new ResponseOK(true);
        }
        catch (Exception e) {
            throw new RuntimeException("Error al agregar pregunta a la base de datos.", e);
        }

    }

    public ResponseOK updateQuestion(QuestionRequestDTO questionsRequestDTO) {
        try{
            var questionEntity = Question.builder()
                    .id(questionsRequestDTO.getId())
                    .question(questionsRequestDTO.getQuestion())
                    .type(questionsRequestDTO.getType().toString().toUpperCase())
                    .ponderation(questionsRequestDTO.getPonderation())
                    .build();

            questionRepository.updateQuestion(questionEntity.getQuestion(), questionEntity.getType(), questionEntity.getPonderation(), questionEntity.getId());

            return new ResponseOK(true);
        }
        catch (Exception e) {
            throw new RuntimeException("Error al modificar pregunta a la base de datos.", e);
        }
    }
}
