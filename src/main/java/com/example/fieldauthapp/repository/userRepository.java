package com.example.fieldauthapp.repository;

import com.example.fieldauthapp.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface userRepository extends JpaRepository<User , Integer> {

    Optional <User> findById(String email);

    Optional<User>findByUsernameAndPassword(String email ,String password);
    Optional <User> findByUsername(String username);

}
