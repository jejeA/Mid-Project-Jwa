package com.example.demo.Jwa.Bank.System.Services.Interface;

import com.example.demo.Jwa.Bank.System.Entity.AccountHolder;

import java.util.List;
import java.util.Optional;

public interface AccountHolderInterface {


    AccountHolder createAccountHolder(AccountHolder accountHolder);
    String updateAccountHolder(int id, AccountHolder accountHolder);
    String deleteAccountHolder(int id);
   List<AccountHolder> getAllAccountHolders();
    Optional<AccountHolder> findByAccountHoldertId(int id);
}
