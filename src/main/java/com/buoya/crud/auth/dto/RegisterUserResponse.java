package com.buoya.crud.auth.dto;

import java.util.UUID;

import com.buoya.crud.common.types.UserRole;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(description = "Response data after user registration")
public class RegisterUserResponse {
    @Schema(description = "ID of the newly created user", example = "c0a8012e-0000-0000-0000-000000000001")
    UUID id;

    @Schema(description = "Username of the newly created user", example = "ayoubbuoya")
    String username;

    @Schema(description = "Email of the newly created user", example = "ayouub.ameur@gmail.com")
    String email;

    @Schema(description = "Role of the newly created user", example = "USER")
    UserRole role;
}
