package com.jorge.cruddemoapplication2.services;

import com.jorge.cruddemoapplication2.models.UserModel;
import com.jorge.cruddemoapplication2.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {
    final IUserRepository userRepository;
    @Autowired
    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ArrayList<UserModel> getUsers() {
        return (ArrayList<UserModel>) userRepository.findAll();
    }

    public UserModel saveUser(UserModel user) {
        return userRepository.save(user);
    }

    public Optional<UserModel> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public Optional<UserModel> updateUserById(Long id, UserModel user) {
        Optional<UserModel> userById = userRepository.findById(id);
        if (userById.isPresent()) {
            UserModel userToUpdate = userById.get();
            userToUpdate.setName(user.getName());
            userToUpdate.setLastName(user.getLastName());
            userToUpdate.setEmail(user.getEmail());
            return Optional.of(userRepository.save(userToUpdate));
        }
        return Optional.empty();
    }

    public boolean deleteUserById(Long id) {
        try {
            userRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
