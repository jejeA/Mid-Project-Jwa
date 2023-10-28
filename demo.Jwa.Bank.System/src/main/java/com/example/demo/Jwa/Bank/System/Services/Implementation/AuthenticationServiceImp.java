package com.example.demo.Jwa.Bank.System.Services.Implementation;

import com.example.demo.Jwa.Bank.System.Entity.Role;
import com.example.demo.Jwa.Bank.System.Entity.User;
import com.example.demo.Jwa.Bank.System.Repository.UserRepository;
import com.example.demo.Jwa.Bank.System.Services.Interface.AuthenticationService;
import com.example.demo.Jwa.Bank.System.Services.Interface.JWTService;
import com.example.demo.Jwa.Bank.System.dots.JwtAuthenticationResponse;
import com.example.demo.Jwa.Bank.System.dots.SignUpRequest;
import com.example.demo.Jwa.Bank.System.dots.SigninRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
class AuthenticationServiceImp implements AuthenticationService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;
    private  final AuthenticationManager authenticationManager;
    private final JWTService jwtService;



    @Override
    public User signup(SignUpRequest signUpRequest) {
        User user= new User();
        user.setEmail(signUpRequest.getEmail());
        user.setName(signUpRequest.getName());
        user.setRoles(Role.USER);
        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));

        return userRepository.save(user);
    }


    @Override
    public JwtAuthenticationResponse signin(SigninRequest signinRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signinRequest.getEmail(),
                signinRequest.getPassword()));


        var user = userRepository.findByEmail(signinRequest.getEmail()).orElseThrow(() -> new IllegalArgumentException("invalid email or password"));
        var jwt = jwtService.generateToken(user);
        var refreshToken= jwtService.generateRefreshToken(new HashMap<>(),user);

        JwtAuthenticationResponse jwtAuthenticationResponse= new JwtAuthenticationResponse();

        jwtAuthenticationResponse.setToken(jwt);
        jwtAuthenticationResponse.setRefreshToken((String) refreshToken);
        return  jwtAuthenticationResponse;
    }


}
