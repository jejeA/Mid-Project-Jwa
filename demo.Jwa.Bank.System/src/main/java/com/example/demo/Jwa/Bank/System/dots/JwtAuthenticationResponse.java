package com.example.demo.Jwa.Bank.System.dots;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Data
@Setter
@Getter

public class JwtAuthenticationResponse {

    private String token;

    private String refreshToken;
}
