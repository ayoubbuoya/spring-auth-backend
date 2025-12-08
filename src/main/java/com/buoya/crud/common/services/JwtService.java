package com.buoya.crud.common.services;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.buoya.crud.common.exceptions.InvalidTokenException;
import com.buoya.crud.common.types.UserJwt;
import com.buoya.crud.common.types.UserRole;
import com.buoya.crud.entities.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;

@Component
public class JwtService {

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.expiration}") // in milliseconds
    private long jwtExpirationMs;

    public String generateToken(User user) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtExpirationMs);

        return Jwts.builder()
                .subject(user.getId().toString())
                .issuedAt(now)
                .expiration(expiryDate)
                .claims(Map.of(
                        "id", user.getId().toString(),
                        "username", user.getUsername(),
                        "email", user.getEmail(),
                        "role", user.getRole().name()))
                .signWith(io.jsonwebtoken.security.Keys.hmacShaKeyFor(jwtSecret.getBytes()))
                .compact();

    }

    // Validate token and return UserJwt
    public UserJwt validateTokenAndGetUser(String token) {
        try {
            Claims claims = (Claims) Jwts.parser()
                    .verifyWith(io.jsonwebtoken.security.Keys.hmacShaKeyFor(jwtSecret.getBytes()))
                    .build()
                    .parse(token).getPayload();

            return new UserJwt(
                    UUID.fromString(claims.get("id", String.class)),
                    claims.get("username", String.class),
                    claims.get("email", String.class),
                    UserRole.valueOf(claims.get("role", String.class)));

        } catch (JwtException | IllegalArgumentException e) {
            throw new InvalidTokenException("Invalid JWT token: " + e.getMessage());
        }
    }
}