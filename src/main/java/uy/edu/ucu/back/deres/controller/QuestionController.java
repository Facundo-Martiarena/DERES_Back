package uy.edu.ucu.back.deres.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import uy.edu.ucu.back.deres.entity.Question;
import uy.edu.ucu.back.deres.model.ResponseOK;
import uy.edu.ucu.back.deres.model.question.QuestionRequestDTO;
import uy.edu.ucu.back.deres.model.user.UserLoginRequestDTO;
import uy.edu.ucu.back.deres.service.QuestionService;

import java.util.List;

@RestController
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @PostMapping("/addQuestion")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @ResponseBody
    private ResponseOK login(@RequestBody QuestionRequestDTO questionRequestDTO){
        return questionService.addQuestion(questionRequestDTO);
    }

    @GetMapping("/questions")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @ResponseBody
    private List<Question> getQuestions() throws Exception {
        return questionService.getQuestions();
    }

}