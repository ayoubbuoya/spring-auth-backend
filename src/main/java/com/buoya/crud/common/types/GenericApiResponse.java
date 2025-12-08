package com.buoya.crud.common.types;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Generic API response wrapper")
public class GenericApiResponse<T> {
    @Schema(description = "Response message", example = "User registered successfully")
    private String message;

    @Schema(description = "Response data")
    private T data;
}
