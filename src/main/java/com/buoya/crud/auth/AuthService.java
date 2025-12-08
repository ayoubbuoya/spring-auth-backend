package com.buoya.crud.auth;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.buoya.crud.auth.dto.RegisterRequest;
import com.buoya.crud.common.exceptions.EmailAlreadyExistsException;
import com.buoya.crud.common.exceptions.UsernameAlreadyExistsException;
import com.buoya.crud.entities.User;
import com.buoya.crud.repository.UserRepository;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerNewUser(RegisterRequest dto) {

        if (userRepository.existsByEmail(dto.getEmail())) {
            throw new EmailAlreadyExistsException(dto.getEmail());
        }

        if (userRepository.existsByUsername(dto.getUsername())) {
            throw new UsernameAlreadyExistsException(dto.getUsername());
        }

        User user = User.builder()
                .username(dto.getUsername())
                .email(dto.getEmail())
                .password(passwordEncoder.encode(dto.getPassword()))
                .build();

        return userRepository.save(user);
    }

}
