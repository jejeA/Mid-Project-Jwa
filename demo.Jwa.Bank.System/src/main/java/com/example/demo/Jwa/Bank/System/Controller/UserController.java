package com.example.demo.Jwa.Bank.System.Controller;//package com.example.demo.Jwa.Bank.System.Controller;
//
//
//import com.example.demo.Jwa.Bank.System.Entity.User;
//import com.example.demo.Jwa.Bank.System.Repository.UserRepository;
//import com.example.demo.Jwa.Bank.System.Services.Implementation.UserServiceImp;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//public class UserController {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private UserServiceImp userServiceImp;
//
//    @GetMapping("/Users")
//    public List<User> getAllUser(){
//        return userServiceImp.getAllUser();
//    }
//    @GetMapping("/{userid}")
//    public ResponseEntity<User> getUserById(@PathVariable int idUser) {
//        User user = userServiceImp.getUserById(idUser);
//        if (user != null) {
//            return ResponseEntity.ok(user);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @PostMapping("/create-user/{id}")
//    public ResponseEntity<User> createUser(@RequestBody User user) {
//        User createdUser = userServiceImp.createUser(user);
//        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
//    }
//
//    @PutMapping("/update/{id}")
//    public ResponseEntity<User> updateUser(@PathVariable int idUser, @RequestBody User user) {
//        User updatedUser = userServiceImp.updateUser(idUser, user);
//        if (updatedUser != null) {
//            return ResponseEntity.ok(updatedUser);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<Void> deleteUser(@PathVariable int idUser) {
//        userServiceImp.deleteUser(idUser);
//        return ResponseEntity.noContent().build();
//    }
//}


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor

public class UserController {

}