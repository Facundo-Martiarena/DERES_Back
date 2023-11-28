package uy.edu.ucu.back.deres.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import uy.edu.ucu.back.deres.entity.User;
import uy.edu.ucu.back.deres.model.ResponseOK;
import uy.edu.ucu.back.deres.model.rabbit.EmailRequest;
import uy.edu.ucu.back.deres.model.user.Privilege;
import uy.edu.ucu.back.deres.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

@Service
public class RabbitService {

    private static final Logger logger = LoggerFactory.getLogger(RabbitService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public ResponseOK sendEmail() throws JsonProcessingException {
        List<String> providers = getEmailList();

        //List<String> providers = new ArrayList<>();
        //providers.add("facumartiarena1995@gmail.com");

        String subject = "Deres - Encuesta actualizada";
        String text = "La encuesta se ha actualizado, ingrese a la web si quiere realizarla de nuevo.";

        if (providers != null && !providers.isEmpty()) {
            for (String provider : providers) {
                EmailRequest emailRequest = new EmailRequest(provider, subject, text);

                String emailRequestJson = new ObjectMapper().writeValueAsString(emailRequest);

                rabbitTemplate.setReplyAddress("noreply@deres.com");
                rabbitTemplate.convertAndSend("deresQueue", emailRequestJson);
            }
            return new ResponseOK(true);
        } else {
            logger.warn("No hay proveedores para enviar correos electrónicos.");
            return new ResponseOK(false);
        }
    }

    public List<String> getEmailList() {
        try {
            List<User> users = userRepository.findAll();
            List<String> emails = new ArrayList<>();

            logger.info("users: {}", users);

            for (User user : users) {
                if (Privilege.PROVIDER.toString().equals(user.getPrivilege())) {
                    emails.add(user.getEmail());
                }
            }

            logger.info("emails: {}", emails);
            return emails;
        } catch (DataAccessException e) {
            logger.error("Error al recuperar los usuarios de la base de datos", e);
            throw e;
        }
    }
}
