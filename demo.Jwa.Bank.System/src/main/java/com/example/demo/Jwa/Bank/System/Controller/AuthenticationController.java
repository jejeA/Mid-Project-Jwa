package com.example.demo.Jwa.Bank.System.Controller;

import com.example.demo.Jwa.Bank.System.Entity.User;
import com.example.demo.Jwa.Bank.System.Services.Interface.AuthenticationService;
import com.example.demo.Jwa.Bank.System.dots.JwtAuthenticationResponse;
import com.example.demo.Jwa.Bank.System.dots.SignUpRequest;
import com.example.demo.Jwa.Bank.System.dots.SigninRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/signup")
    public ResponseEntity<User>signup(@RequestBody SignUpRequest signUpRequest){
        return ResponseEntity.ok(authenticationService.signup(signUpRequest));

    }
    @PostMapping("/signin")
    public  ResponseEntity<JwtAuthenticationResponse>signin(@RequestBody SigninRequest signinRequest){
        return  ResponseEntity.ok(authenticationService.signin(signinRequest));
    }
}
