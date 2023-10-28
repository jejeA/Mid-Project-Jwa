package com.example.demo.Jwa.Bank.System.Entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Objects;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data

@Table(name = "tbl_AccountHolder")
public class AccountHolder extends User{


    @OneToOne
    private Account account;

    public AccountHolder(int idUser, String name, String email, String password, String address,Account account) {
        super(idUser, name, email, password, address);
        setAccount(account);
    }

}

//    public Account getAccount() {
//        return account;
//    }
//
//    public void setAccount(Account account) {
//        this.account = account;
//    }

//    public int getAccountNumber() {
//        return AccountNumber;
//    }
//
//    public void setAccountNumber(int accountNumber) {
//        AccountNumber = accountNumber;
//    }

//    @Override
//    public String toString() {
//        return "AccountHolder{" +
//                "account=" + account +
//                ", AccountNumber=" + AccountNumber +
//                '}';
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        if (!super.equals(o)) return false;
//        AccountHolder that = (AccountHolder) o;
//        return AccountNumber == that.AccountNumber && Objects.equals(account, that.account);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(super.hashCode(), account, AccountNumber);
//    }



