package com.example.demo.Jwa.Bank.System.Services.Implementation;

import com.example.demo.Jwa.Bank.System.Entity.User;
import com.example.demo.Jwa.Bank.System.Services.Interface.JWTService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JWTServiceImp implements JWTService {

    public String generateToken(UserDetails userDetails) {
        return Jwts.builder().setSubject(userDetails.getUsername()).setIssuedAt(new Date(System
                        .currentTimeMillis())).setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
                .signWith(getSignKey(), SignatureAlgorithm.HS256).compact();

    }


    public String generateRefreshToken(Map<String , Object> extraClaims, UserDetails userDetails) {
        return Jwts.builder().setClaims(extraClaims).setSubject(userDetails.getUsername()).setIssuedAt(new Date(System
                        .currentTimeMillis())).setExpiration(new Date(System.currentTimeMillis() + 604800000))
                .signWith(getSignKey(), SignatureAlgorithm.HS256).compact();

    }

    public  String extractUserName(String token){
        return  extractClaim(token,Claims::getSubject);
    }
    private <T> T extractClaim(String token, Function<Claims,T>claimsResolvers){
        final Claims claims=extractAllClaims(token);
        return claimsResolvers.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token).getBody();
    }

    private Key getSignKey() {
        byte[] key = Decoders.BASE64.decode("0987654345678900987654345678900987654334567890976");
        return Keys.hmacShaKeyFor(key);
    }
    public Boolean isTokenValid(String token , UserDetails userDetails){
        final String username= extractUserName(token);
        return (username.equals(userDetails.getUsername())&& !isTokenExpired(token));

    }


    private Boolean isTokenExpired(String token){
        return extractClaim(token , Claims::getExpiration).before(new Date());
    }

}
