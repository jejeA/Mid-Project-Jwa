package com.example.demo.Jwa.Bank.System.Repository;

import com.example.demo.Jwa.Bank.System.Entity.Account;
import com.example.demo.Jwa.Bank.System.Entity.AccountHolder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AccountRepositoryTest {
@Autowired
    private AccountRepository accountRepository;
private Account account;
@Autowired
private AccountHolderRepository accountHolderRepository;
private AccountHolder accountHolder;

@Test
public void setup(){
    account =new Account(123113,50000.0,accountHolder);
    accountRepository.save(account);
}
}