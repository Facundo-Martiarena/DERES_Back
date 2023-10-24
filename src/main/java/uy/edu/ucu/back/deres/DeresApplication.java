package uy.edu.ucu.back.deres;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class DeresApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeresApplication.class, args);
	}

}
