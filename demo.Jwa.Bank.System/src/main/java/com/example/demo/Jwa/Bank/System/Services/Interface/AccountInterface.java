package com.example.demo.Jwa.Bank.System.Services.Interface;

import com.example.demo.Jwa.Bank.System.Entity.Account;

import java.util.List;

public interface AccountInterface {


    String deposit(int accountNumber, double amount);
    String withdraw(int accountNumber, double amount);
    String transfer(int sourceAccountNumber, int targetAccountNumber, double amount);
    String showBalance(int accountNumber);

    Account addAccount(Account account);

    List<Account> getAllAccount();


//    String deleteAccount(int accountNumber);
}