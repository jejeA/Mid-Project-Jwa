package com.example.demo.Jwa.Bank.System;

import com.example.demo.Jwa.Bank.System.Entity.Role;
import com.example.demo.Jwa.Bank.System.Entity.User;
import com.example.demo.Jwa.Bank.System.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class Application implements CommandLineRunner {
	private UserRepository userRepository;
	@Autowired

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User adminAccount = userRepository.findByRole(Role.ADMIN);
		if(null==adminAccount){
			User user= new User();

			user.setEmail("Admin@gmail.com");
			user.setName("Admin");
			user.setRoles(Role.ADMIN);
			user.setPassword(new BCryptPasswordEncoder().encode("Admin"));
			userRepository.save(user);

		}

	}
}
