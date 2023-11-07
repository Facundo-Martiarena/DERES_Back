package uy.edu.ucu.back.deres.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import uy.edu.ucu.back.deres.entity.User;
import uy.edu.ucu.back.deres.model.ResponseOK;
import uy.edu.ucu.back.deres.model.user.UserLoginRequestDTO;
import uy.edu.ucu.back.deres.model.user.UserSignupRequestDTO;
import uy.edu.ucu.back.deres.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public ResponseOK loginUser(UserLoginRequestDTO userRequestDTO){
        return new ResponseOK(true);
    }

    public ResponseOK signupUser(UserSignupRequestDTO userRequestDTO) throws Exception {
        try {
            var user = User.builder()
                    .username(userRequestDTO.getName())
                    .password(userRequestDTO.getPassword())
                    .privilege(userRequestDTO.getPrivilege().toString().toUpperCase())
                    .email(userRequestDTO.getEmail())
                    .build();
            userRepository.save(user);
            return new ResponseOK(true);

        } catch (DataIntegrityViolationException e){
            throw new Exception("El usuario ya existe.", e);
        } catch (Exception e) {
            throw new Exception("Error al registrar el usuario.", e);
        }
    }

    public List<User> getUsers() {
        try {
            List<User> users = userRepository.findAll();
            return users;
        } catch (DataAccessException e) {
            throw new RuntimeException("Error al obtener usuarios de la base de datos.", e);
        }

    }
}
