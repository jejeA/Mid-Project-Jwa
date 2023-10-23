package com.example.demo.Jwa.Bank.System.Entity;


import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Table(name = "tbl_AccountHolder")
public class AccountHolder extends User{

@OneToMany(mappedBy = "accountHolder")
    private List<Account> account;

}
