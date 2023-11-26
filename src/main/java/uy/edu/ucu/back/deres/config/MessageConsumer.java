package uy.edu.ucu.back.deres.config;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import uy.edu.ucu.back.deres.model.rabbit.EmailRequest;

@Component
public class MessageConsumer {

    JavaMailSender javaMailSender;

    @RabbitListener(queues = "deresQueue")
    public void handleEmailRequest(EmailRequest emailRequest) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(emailRequest.getTo());
        message.setSubject(emailRequest.getSubject());
        message.setText(emailRequest.getText());

        javaMailSender.send(message);
    }
}