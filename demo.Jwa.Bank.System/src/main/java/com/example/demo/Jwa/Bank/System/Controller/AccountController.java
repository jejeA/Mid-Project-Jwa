package com.example.demo.Jwa.Bank.System.Controller;

import com.example.demo.Jwa.Bank.System.Entity.Account;
import com.example.demo.Jwa.Bank.System.Entity.AccountHolder;
import com.example.demo.Jwa.Bank.System.Services.Implementation.AccountServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class  AccountController {

    @Autowired
    private AccountServiceImp accountServiceImp;


    @GetMapping("/accounts")
    public List<Account> getAllAccount() {
        return accountServiceImp.getAllAccount();
    }



    @PostMapping("/add/account")
    public ResponseEntity<String> addAccoun(@RequestBody Account account) {
        try {

            accountServiceImp.addAccount(account);
            String message = "Account added successfully";
            return ResponseEntity.status(HttpStatus.CREATED).body(message);
        }
        catch (Exception e) {
            String errormessage="Account not added successfully";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errormessage);

        }
    }


    @PostMapping("/deposit/{accountNumber}")
    public ResponseEntity<String> deposit(@PathVariable int accountNumber, @RequestParam double amount) {
        try {
            String message = accountServiceImp.deposit(accountNumber, amount);
            return ResponseEntity.status(HttpStatus.OK).body(message);

        } catch (Exception e) {
            String errormessage = "deposit not added seccessfully";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errormessage);
        }
    }

    @PostMapping("/withdraw/{accountNumber}")
    public ResponseEntity<String> withdraw(@PathVariable int accountNumber, @RequestParam double amount) {
        try {
            String response = accountServiceImp.withdraw(accountNumber, amount);
            return ResponseEntity.status(HttpStatus.OK).body(response);

        } catch (Exception e) {
            String errormessage = "deposit not added seccessfully";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errormessage);
        }

    }

    @PostMapping("/transfer")
    public ResponseEntity<String> transfer(
            @RequestBody int sourceAccountNumber,
            @RequestBody int targetAccountNumber,
            @RequestBody double amount
    ) {
        String response = accountServiceImp.transfer(sourceAccountNumber, targetAccountNumber, amount);
        HttpStatus status = response.contains("successful") ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(response, status);
    }

        @GetMapping("/balance/{accountNumber}")
    public ResponseEntity<String> showBalance(@PathVariable int accountNumber) {
        try {
           String response = accountServiceImp.showBalance(accountNumber);
                return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            String errorMessage = "Failed to retrieve balance for account number: " + accountNumber;
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }


}


