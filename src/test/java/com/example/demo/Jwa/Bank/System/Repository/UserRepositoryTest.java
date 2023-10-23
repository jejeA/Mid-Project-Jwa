package com.example.demo.Jwa.Bank.System.Repository;

import com.example.demo.Jwa.Bank.System.Entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;
    private User user1;

  @Test
    public void setup(){
      user1=new User(12,"Jawaher","Riyadh","Ad112312","ad.jawaher25@gmail.com",23);
      userRepository.save(user1);

  }




}