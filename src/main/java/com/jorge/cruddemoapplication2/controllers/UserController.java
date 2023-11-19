package com.jorge.cruddemoapplication2.controllers;

import com.jorge.cruddemoapplication2.models.UserModel;
import com.jorge.cruddemoapplication2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    final UserService userService;
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping({"", "/", "get-all"})
    public ArrayList<UserModel> getUsers() {
        return this.userService.getUsers();
    }

    @PostMapping
    public UserModel saveUser(@RequestBody UserModel user) {
        return this.userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public Optional<UserModel> getUserById(@PathVariable("id") Long id) {
        return this.userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public Optional<UserModel> updateUserById(@PathVariable("id") Long id, @RequestBody UserModel user) {
        return this.userService.updateUserById(id, user);
    }

    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable("id") Long id) {
        boolean ok = this.userService.deleteUserById(id);
        if (ok) {
            return "Se eliminó el usuario con id " + id;
        } else {
            return "No pudo eliminar el usuario con id " + id;
        }
    }
}
