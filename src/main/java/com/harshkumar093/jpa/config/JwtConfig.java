package com.harshkumar093.jpa.config;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.Date;
import java.util.Map;

@Configuration
public class JwtConfig {
    @Value("${assignment.app.jwtSecret}")
    private String secret;

    @Value("${assignment.app.jwtExpirationMs}")
    private int jwtExpirationMs;

    public String generateToken(Map<String, Object> claims) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtExpirationMs);
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public Claims getClaimsFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        } catch (MalformedJwtException e) {
            System.out.println("Invalid JWT token: {}"+ e.getMessage());
        } catch (ExpiredJwtException e) {
            System.out.println("JWT token is expired: {}"+ e.getMessage());
        } catch (UnsupportedJwtException e) {
            System.out.println("JWT token is unsupported: {}"+ e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("JWT claims string is empty: {}"+ e.getMessage());
        }

        return false;
    }
}
