package uy.edu.ucu.back.deres.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import uy.edu.ucu.back.deres.entity.User;
import uy.edu.ucu.back.deres.model.ResponseOK;
import uy.edu.ucu.back.deres.model.UserLoginRequestDTO;
import uy.edu.ucu.back.deres.model.UserSignupRequestDTO;
import uy.edu.ucu.back.deres.service.UserService;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @ResponseBody
    private ResponseOK login(@RequestBody UserLoginRequestDTO userRequestDTO){
        return userService.loginUser(userRequestDTO);
    }

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @ResponseBody
    private ResponseOK signup(@RequestBody UserSignupRequestDTO userRequestDTO) throws Exception {
        return userService.signupUser(userRequestDTO);
    }

    @GetMapping("/users")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @ResponseBody
    private List<User> getUsers() throws Exception {
        return userService.getUsers();
    }
}
