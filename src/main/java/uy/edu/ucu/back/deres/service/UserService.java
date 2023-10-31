package uy.edu.ucu.back.deres.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import uy.edu.ucu.back.deres.entity.User;
import uy.edu.ucu.back.deres.model.ResponseOK;
import uy.edu.ucu.back.deres.repository.UserRepository;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    private UserRepository userRepository;

    public ResponseOK loginUser(User userRequestDTO){
        return new ResponseOK(true);
    }

    public ResponseOK signupUser(User userRequestDTO) throws Exception {
        try {
            UUID id = UUID.randomUUID();
            userRequestDTO.setId(id);
            userRepository.save(userRequestDTO);
            return new ResponseOK(true);
        }catch (DataIntegrityViolationException e){
            throw new Exception("El usuario ya existe.", e);
        }catch (Exception e) {
            throw new Exception("Error al registrar el usuario.", e);
        }

    }

    public List<User> getUsers() {
        try {
            List<User> users = userRepository.findAll();
            return users;
        }catch (DataAccessException e) {
            throw new RuntimeException("Error al obtener usuarios de la base de datos.", e);
        }

    }


}
