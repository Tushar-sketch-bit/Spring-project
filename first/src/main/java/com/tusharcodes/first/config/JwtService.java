package com.tusharcodes.first.config;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

@Service
public class JwtService {
    private static final String SECRET_KEY = "your-256-bit-secret-key-of-minimum-32-chars";

    private Key getSignInKey(){
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }

    public String generateToken(String email) {
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 hours
                .signWith(SignatureAlgorithm.HS256, getSignInKey())
                .compact();

    }

    public <T> T extractClaim(String token,Function<Claims, T> claimsResolver) {
        Claims claims = Jwts
                .parser()
                .setSigningKey(getSignInKey())
                .parseClaimsJws(token)
                .getBody();
        return claimsResolver.apply(claims);
    }















}
