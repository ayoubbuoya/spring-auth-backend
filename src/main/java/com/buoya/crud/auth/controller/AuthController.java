package com.buoya.crud.auth.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/auth")
@Tag(name = "AUTH")
public class AuthController {

    @GetMapping("/test")
    public String getMethodName() {
        return new String("Hello There");
    }

}
