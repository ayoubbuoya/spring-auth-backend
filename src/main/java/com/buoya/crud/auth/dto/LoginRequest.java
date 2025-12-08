package com.buoya.crud.auth.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Schema(description = "Login request")
@Data
public class LoginRequest {

    @Schema(description = "User Identifier which can be email or username", example = "ayouub.ameur@gmail.com")
    @NotBlank
    private String identifier;

    @Schema(description = "User Password", example = "123456")
    @NotBlank
    private String password;
}
