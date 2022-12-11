package com.example.fieldauthapp.model.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class registerDto {

    @NotBlank
    @Size(min = 3, max = 20)
    private String username;

    @NotBlank
    @Size(min = 6, max = 40)
    private String password;

    @NotBlank
    @Size(min = 3, max = 20)
    private String lastname;

    @NotBlank
    @Size(min = 3, max = 20)
    private String firstname;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;


    public User registerDtoUser(registerDto registerdto){

         User user = new User();
         user.setFirstName(registerdto.getFirstname());
         user.setEmail(registerdto.getEmail());
         user.setUsername(registerdto.getUsername());
         user.setLastName(registerdto.getLastname());
         user.setPassword(registerdto.getPassword());

         return user;
    }
}
