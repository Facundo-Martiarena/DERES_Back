package uy.edu.ucu.back.deres.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import uy.edu.ucu.back.deres.entity.Answer;
import uy.edu.ucu.back.deres.model.ResponseOK;
import uy.edu.ucu.back.deres.model.answer.AnswersRequestDTO;
import uy.edu.ucu.back.deres.service.AnswerService;

import java.util.List;

@RestController
public class AnswerController {
    @Autowired
    private AnswerService answerService; 

    @GetMapping("/answers/{provider_rut}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @ResponseBody
    public List<Answer> getAnswers(@PathVariable("provider_rut") String providerRut) {
        return answerService.getByProviderRut(providerRut);
    }

    @PostMapping("/answers/{provider_rut}")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseOK addAnswers(@RequestBody AnswersRequestDTO answersRequestDTO, @PathVariable("provider_rut") String providerRut) {
        return answerService.addAnswers(answersRequestDTO, providerRut);
    }
}
