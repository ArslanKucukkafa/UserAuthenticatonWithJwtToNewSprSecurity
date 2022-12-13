package com.example.fieldauthapp;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Authorizaton Apı", version = "2.0", description = "Employees Information"))
public class FieldAuthAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(FieldAuthAppApplication.class, args);
    }

}
