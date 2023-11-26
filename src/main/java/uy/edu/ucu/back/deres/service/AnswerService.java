package uy.edu.ucu.back.deres.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uy.edu.ucu.back.deres.entity.Answer;
import uy.edu.ucu.back.deres.model.ResponseOK;
import uy.edu.ucu.back.deres.model.answer.AnswerRequestDTO;
import uy.edu.ucu.back.deres.repository.AnswerRepository;

import java.util.List;

@Service
public class AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    public ResponseOK addAnswer(AnswerRequestDTO answerDTO) {
        try {
            var answer = Answer.builder()
                    .answer(answerDTO.getAnswer())
                    .questionID(answerDTO.getQuestionID())
                    .providerRut(answerDTO.getProviderRut())
                    .build();
            answerRepository.save(answer);
            return new ResponseOK(true);
        } catch (Exception e) {
            throw new RuntimeException("Error al agregar respuesta a la base de datos.", e);
        }
    }

    public ResponseOK updateAnswer(AnswerRequestDTO answerDTO) {
        try {
            var answer = answerRepository.findById(answerDTO.getQuestionID());
            answer.get().setAnswer(answerDTO.getAnswer());
            return new ResponseOK(true);
        } catch (Exception e) {
            throw new RuntimeException("Error al actualizar respuesta a la base de datos.", e);
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
