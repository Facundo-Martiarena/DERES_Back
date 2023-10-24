package uy.edu.ucu.back.deres.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import uy.edu.ucu.back.deres.model.UserRequestDTO;
import uy.edu.ucu.back.deres.model.ResponseOK;

@Service
public class UserService {

    private JdbcTemplate jdbcTemplate;
    public ResponseOK loginUser(UserRequestDTO userRequestDTO){
        jdbcTemplate.query();
        return new ResponseOK(true);
    }

    public ResponseOK signupUser(UserRequestDTO userRequestDTO){
        return new ResponseOK(true);
    }


}
