package uy.edu.ucu.back.deres.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import uy.edu.ucu.back.deres.model.UserRequestDTO;
import uy.edu.ucu.back.deres.model.ResponseOK;
import uy.edu.ucu.back.deres.service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @ResponseBody
    private ResponseOK login(@RequestBody UserRequestDTO userRequestDTO){
        return userService.loginUser(userRequestDTO);
    }

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @ResponseBody
    private ResponseOK signup(@RequestBody UserRequestDTO userRequestDTO){
        return userService.signupUser(userRequestDTO);
    }


}
