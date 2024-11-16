package com.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.entity.User;
import com.crud.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private final UserRepository  userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //create
    public User creaUser(User user) {
        return userRepository.save(user);
    }

    //read all
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    //read by id
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    //update
    public User updateUser(Long id, User userDetails) {
        User user=userRepository.findById(id).orElseThrow(()->new RuntimeException("User not found with id " + id));
        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        return userRepository.save(user);
    }

    //delete
    public void deleteUser(Long id){
        User user=userRepository.findById(id).orElseThrow(()->new RuntimeException("User not found with id " + id));
        userRepository.delete(user);
    }

}
