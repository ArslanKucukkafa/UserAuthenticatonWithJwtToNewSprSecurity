package com.example.fieldauthapp.model.user;

import lombok.*;

import javax.validation.constraints.NotBlank;


@Data
public class loginDto {

    @NotBlank
    private String username;

    @NotBlank
    private String password;
}
