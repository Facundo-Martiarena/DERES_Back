package uy.edu.ucu.back.deres.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import uy.edu.ucu.back.deres.model.rabbit.EmailRequest;

@Component
public class MessageConsumer {

    @Autowired
    private JavaMailSender javaMailSender;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @RabbitListener(queues = "deresQueue")
    public void handleEmailRequest(String emailRequestJson) {
        try {
            EmailRequest emailRequest = objectMapper.readValue(emailRequestJson, EmailRequest.class);

            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(emailRequest.getTo());
            message.setSubject(emailRequest.getSubject());
            message.setText(emailRequest.getText());

            javaMailSender.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
