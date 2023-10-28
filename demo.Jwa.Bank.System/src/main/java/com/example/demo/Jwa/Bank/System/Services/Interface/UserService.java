package com.example.demo.Jwa.Bank.System.Services.Interface;

import com.example.demo.Jwa.Bank.System.Repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {
    UserDetailsService userDetailsService();
}
