package com.example.demo.Jwa.Bank.System.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Data
@Table(name = "tbl_CheckingAccount")
public class CheckingAccount extends Account{

    private double OverDraftLimit;

}
