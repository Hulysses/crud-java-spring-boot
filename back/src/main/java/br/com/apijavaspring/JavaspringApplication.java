package br.com.apijavaspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class JavaspringApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaspringApplication.class, args);
    }
}