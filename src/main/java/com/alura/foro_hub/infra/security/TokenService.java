package com.alura.foro_hub.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private long expirationTime;

    public String generateToken(String username){
        return JWT.create()
                .withSubject(username)
                .withExpiresAt(new Date(System.currentTimeMillis()+ expirationTime ))
                .sign(Algorithm.HMAC256(secret));
    }

    public boolean validateToken(String token){
        try{
            JWT.require(Algorithm.HMAC256(secret)).build().verify(token);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public String getUsernameFromToken(String token){
        return JWT.require(Algorithm.HMAC256(secret)).build().verify(token).getSubject();
    }

}
