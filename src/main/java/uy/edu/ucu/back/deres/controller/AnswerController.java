package uy.edu.ucu.back.deres.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import uy.edu.ucu.back.deres.entity.Answer;
import uy.edu.ucu.back.deres.model.ResponseOK;
import uy.edu.ucu.back.deres.model.answer.AnswerRequestDTO;
import uy.edu.ucu.back.deres.service.AnswerService;

public class AnswerController {
    @Autowired
    private AnswerService answerService; 

    @GetMapping("/answers/{providerRut}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @ResponseBody
    public List<Answer> getAnswers(@PathVariable("providerRut") String providerRut) {
        return answerService.getByProvider(providerRut);
    }

    @PostMapping("/answers")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseOK addAnswer(@RequestBody AnswerRequestDTO answerRequestDTO) {
        return answerService.addAnswer(answerRequestDTO);
    }

    @PutMapping("/answers")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseOK updateAnswer(@RequestBody AnswerRequestDTO answerRequestDTO) {
        return answerService.updateAnswer(answerRequestDTO);
    }
}
