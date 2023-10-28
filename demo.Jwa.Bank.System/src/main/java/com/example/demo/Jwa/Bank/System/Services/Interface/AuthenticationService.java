package com.example.demo.Jwa.Bank.System.Services.Interface;

import com.example.demo.Jwa.Bank.System.Entity.User;
import com.example.demo.Jwa.Bank.System.dots.JwtAuthenticationResponse;
import com.example.demo.Jwa.Bank.System.dots.SignUpRequest;
import com.example.demo.Jwa.Bank.System.dots.SigninRequest;

public interface AuthenticationService  {

    JwtAuthenticationResponse signin(SigninRequest signinRequest);
    User signup (SignUpRequest signUpRequest);
}
