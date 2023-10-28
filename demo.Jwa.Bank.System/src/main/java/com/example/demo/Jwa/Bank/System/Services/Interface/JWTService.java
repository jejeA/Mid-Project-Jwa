package com.example.demo.Jwa.Bank.System.Services.Interface;

import com.example.demo.Jwa.Bank.System.Entity.User;
import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.HashMap;
import java.util.Map;

public interface JWTService {

     String extractUserName(String token);
 String generateToken(UserDetails userDetails) ;
    Boolean isTokenValid(String token , UserDetails userDetails);

    Object generateRefreshToken(Map<String, Object> extraClaims, UserDetails userDetails);
}
