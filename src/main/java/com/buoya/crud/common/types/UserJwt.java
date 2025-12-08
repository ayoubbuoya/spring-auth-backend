package com.buoya.crud.common.types;

import java.util.UUID;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(description = "User JWT Payload")
public class UserJwt {

    @Schema(description = "User ID", example = "c0a8012e-0000-0000-0000-000000000001")
    private UUID id;

    @Schema(description = "User Username", example = "ayoubbuoya")
    private String username;

    @Schema(description = "User Email", example = "ayouub.ameur@gmail.com")
    private String email;

    @Schema(description = "User Role", example = "USER")
    private UserRole role;
}
