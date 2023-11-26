package uy.edu.ucu.back.deres.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uy.edu.ucu.back.deres.entity.User;
import uy.edu.ucu.back.deres.model.ResponseOK;
import uy.edu.ucu.back.deres.model.rabbit.EmailRequest;
import uy.edu.ucu.back.deres.model.user.Privilege;
import uy.edu.ucu.back.deres.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

@Service
public class RabbitService {

    @Autowired
    private UserRepository userRepository;

    private RabbitTemplate rabbitTemplate;

    public ResponseOK sendEmail() throws Exception {

        List<String> providers = getEmailList();

        String subject = "prueba";
        String text = "prueba";

        if (providers != null) {
            for (String provider : providers) {
                EmailRequest emailRequest = new EmailRequest(provider, subject, text);
                rabbitTemplate.convertAndSend("deresQueue", emailRequest);
            }
        }

        return new ResponseOK(true);

    }

    public List<String> getEmailList() throws Exception {

        try {
            List<User> users = userRepository.findAll();
            List<String> emails = new ArrayList<>();

            for(User user : users){
                if(user.getPrivilege().equals(Privilege.PROVIDER)){
                    emails.add(user.getEmail());
                }
            }
            return emails;
        }catch (Exception e){
            throw new Exception(e);
        }


    }
}
