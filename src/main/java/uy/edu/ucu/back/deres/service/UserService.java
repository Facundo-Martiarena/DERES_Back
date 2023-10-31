package uy.edu.ucu.back.deres.service;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import uy.edu.ucu.back.deres.entity.User;
import uy.edu.ucu.back.deres.model.ResponseOK;
import uy.edu.ucu.back.deres.model.UserLoginRequestDTO;
import uy.edu.ucu.back.deres.model.UserSignupRequestDTO;
import uy.edu.ucu.back.deres.repository.UserRepository;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    private UserRepository userRepository;

    public ResponseOK loginUser(UserLoginRequestDTO userRequestDTO){
        return new ResponseOK(true);
    }

    public ResponseOK signupUser(UserSignupRequestDTO userRequestDTO) throws Exception {
        try {
            UUID id = UUID.randomUUID();
            var user = User.builder()
                    .id(id)
                    .name(userRequestDTO.getName())
                    .password(userRequestDTO.getPassword())
                    .privilege(userRequestDTO.getPrivilege().toString())
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
        }catch (DataAccessException e) {
            throw new RuntimeException("Error al obtener usuarios de la base de datos.", e);
        }

    }


}
