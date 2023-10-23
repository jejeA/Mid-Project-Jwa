package com.example.demo.Jwa.Bank.System.Repository;

import com.example.demo.Jwa.Bank.System.Entity.AccountHolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountHolderRepository  extends JpaRepository<AccountHolder,Integer > {
}
