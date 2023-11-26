package uy.edu.ucu.back.deres.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import uy.edu.ucu.back.deres.model.ResponseOK;
import uy.edu.ucu.back.deres.service.RabbitService;

@Controller
public class RabbitController {

    @Autowired
    private RabbitService rabbitService;


    @PostMapping("/send-mails")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseOK sendMail() throws Exception {
        return rabbitService.sendEmail();
    }


}
