package uy.edu.ucu.back.deres.model.rabbit;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EmailRequest {

    private String to;
    private String subject;
    private String text;

    public EmailRequest() {
    }
}
