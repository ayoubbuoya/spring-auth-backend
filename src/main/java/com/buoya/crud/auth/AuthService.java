package com.buoya.crud.auth;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.buoya.crud.auth.dto.LoginRequest;
import com.buoya.crud.auth.dto.LoginResponse;
import com.buoya.crud.auth.dto.RegisterRequest;
import com.buoya.crud.auth.dto.RegisterUserResponse;
import com.buoya.crud.common.exceptions.EmailAlreadyExistsException;
import com.buoya.crud.common.exceptions.InvalidCredentialsException;
import com.buoya.crud.common.exceptions.UsernameAlreadyExistsException;
import com.buoya.crud.common.services.JwtService;
import com.buoya.crud.entities.User;
import com.buoya.crud.repository.UserRepository;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public AuthService(UserRepository userRepository, JwtService jwtService) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
    }

    public User registerNewUser(RegisterRequest dto) {

        if (userRepository.existsByEmail(dto.getEmail())) {
            throw new EmailAlreadyExistsException(dto.getEmail());
        }

        if (userRepository.existsByUsername(dto.getUsername())) {
            throw new UsernameAlreadyExistsException(dto.getUsername());
        }

        // Generate a new Hedera account
        

        User user = User.builder()
                .username(dto.getUsername())
                .email(dto.getEmail())
                .password(passwordEncoder.encode(dto.getPassword()))
                .build();

        return userRepository.save(user);
    }

    public LoginResponse login(LoginRequest dto) {
        User user = userRepository.findByEmailOrUsername(dto.getIdentifier())
                .orElseThrow(() -> new InvalidCredentialsException("Invalid email/username or password"));

        if (!passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
            throw new InvalidCredentialsException("Invalid email/username or password");
        }

        // Generate JWT token
        String token = jwtService.generateToken(user);

        return new LoginResponse(
                token,
                new RegisterUserResponse(user.getId(), user.getUsername(), user.getEmail(), user.getRole()));
    }

}
