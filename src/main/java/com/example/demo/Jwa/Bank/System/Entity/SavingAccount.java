package com.example.demo.Jwa.Bank.System.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_SavingAccount")
public class SavingAccount extends Account{
    private double InterestRate;

}
