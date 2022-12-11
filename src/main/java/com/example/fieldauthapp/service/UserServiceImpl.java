package com.example.fieldauthapp.service;

import com.example.fieldauthapp.model.user.User;
import com.example.fieldauthapp.model.user.registerDto;
import com.example.fieldauthapp.model.user.userDetailsDto;
import com.example.fieldauthapp.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    private userRepository userrepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userrepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

        return new userDetailsDto(user);
    }

    public void registerDto(registerDto registerdto){
        registerdto.setPassword(passwordEncoder.encode(registerdto.getPassword()));
        userrepository.save(registerdto.registerDtoUser(registerdto));
    }

}
