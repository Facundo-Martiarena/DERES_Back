package uy.edu.ucu.back.deres.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uy.edu.ucu.back.deres.entity.Answer;
import uy.edu.ucu.back.deres.model.ResponseOK;
import uy.edu.ucu.back.deres.model.answer.AnswerRequestDTO;
import uy.edu.ucu.back.deres.model.answer.AnswersRequestDTO;
import uy.edu.ucu.back.deres.repository.AnswerRepository;

import java.util.List;

@Service
public class AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    public ResponseOK addAnswers(AnswersRequestDTO answersDTO, String providerRUT) {
        try {
            //replace with new answers
            getByProvider(providerRUT).forEach(answer -> answerRepository.delete(answer));
            for (AnswerRequestDTO answerDTO : answersDTO.getQuestions()) {
                var answer = Answer.builder()
                        .answer(answerDTO.getAnswer())
                        .questionID(answerDTO.getQuestionID())
                        .providerRut(providerRUT)
                        .build();
                answerRepository.save(answer);
            }
            return new ResponseOK(true);
        } catch (Exception e) {
            throw new RuntimeException("Error al agregar respuesta a la base de datos.", e);
        }
    }

    public List<Answer> getByProvider(String providerRut) {
        try {
            List<Answer> answers = answerRepository.findByProviderRut(providerRut);
            return answers;
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener respuesta de la base de datos.", e);
        }
    }
}
