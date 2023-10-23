package com.example.demo.Jwa.Bank.System.Entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_User")
public class User {
    @Id
    private int idUser;
    private String name;
    private  String address;
    private  String password;
    private String email;
    private int age;

}
