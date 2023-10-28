package com.example.demo.Jwa.Bank.System.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Setter
@Getter
@NoArgsConstructor

@Table(name = "tbl_Account")
public class Account {

    private String AccountName;

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
    private int accountNumber;

    private double balance;


    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus;

//    @OneToOne(cascade = CascadeType.ALL)
//    private AccountHolder accountHolder;

    public Account(String accountName, int accountNumber, double balance, AccountStatus accountStatus) {
        AccountName = accountName;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountStatus = accountStatus;

    }
}


