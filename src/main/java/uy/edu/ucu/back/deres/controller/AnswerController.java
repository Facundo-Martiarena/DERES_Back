package uy.edu.ucu.back.deres.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import uy.edu.ucu.back.deres.entity.Answer;
import uy.edu.ucu.back.deres.model.ResponseOK;
import uy.edu.ucu.back.deres.model.answer.AnswerRequestDTO;
import uy.edu.ucu.back.deres.service.AnswerService;

import java.util.List;

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
