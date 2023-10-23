package com.example.demo.Jwa.Bank.System.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Inheritance
@Table(name = "tbl_Account")
public class Account {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private int AccountNumber;
    private  double balance;
    @ManyToOne
    private AccountHolder accountHolder;


}
