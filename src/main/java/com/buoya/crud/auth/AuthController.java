package com.buoya.crud.auth;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.buoya.crud.auth.dto.RegisterRequest;
import com.buoya.crud.auth.dto.RegisterUserResponse;
import com.buoya.crud.common.types.GenericApiResponse;
import com.buoya.crud.entities.User;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/api/auth")
@Tag(name = "AUTH")

public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/welcome")
    public String getMethodName() {
        return new String("Welcome to CRUD WITH JWT AUTH");
    }

    @Operation(summary = "Register a new user", description = "Create a new user with the given username, email and password", responses = {
            @ApiResponse(responseCode = "200", description = "User registered successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GenericApiResponse.class))),
            @ApiResponse(responseCode = "409", description = "User already exists", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GenericApiResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GenericApiResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GenericApiResponse.class)))

    })
    @PostMapping("/register")
    public ResponseEntity<GenericApiResponse<RegisterUserResponse>> registerUser(
            @Valid @RequestBody RegisterRequest request) {
        User user = authService.registerNewUser(request);

        RegisterUserResponse registerUserResponse = new RegisterUserResponse(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getRole());

        return ResponseEntity.ok(
                new GenericApiResponse<RegisterUserResponse>(
                        "User registered successfully",
                        registerUserResponse));
    }

}
