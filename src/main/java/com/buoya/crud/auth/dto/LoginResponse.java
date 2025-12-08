package com.buoya.crud.auth.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Schema(description = "Login response")
@Data
@AllArgsConstructor
public class LoginResponse {

    @Schema(description = "Access token used to authenticate API requests", example = "e")
    private String accessToken;

    @Schema(description = "User data", example = "{\"id\": \"c0a8012e-0000-0000-0000-000000000001\", \"username\": \"ayoubbuoya\", \"email\": \"ayouub.ameur@gmail.com\", \"role\": \"USER\"}")
    private RegisterUserResponse user;

}
