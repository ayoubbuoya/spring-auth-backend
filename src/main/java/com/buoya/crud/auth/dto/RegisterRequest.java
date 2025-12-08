package com.buoya.crud.auth.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(description = "Request payload to register a new user")
public class RegisterRequest {

    @NotBlank
    @Size(min = 3, max = 50)
    @Schema(description = "Username of the user", example = "ayoubbuoya")
    private String username;

    @NotBlank
    @Email
    @Schema(description = "Email of the user", example = "ayouub.ameur@gmail.com")
    private String email;

    @NotBlank
    @Size(min = 6, message = "Password must be at least 6 characters")
    @Schema(description = "Password of the user", example = "123456")
    private String password;
}
