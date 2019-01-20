package com.yang.eventhost.service;

import com.yang.eventhost.entity.User;
import com.yang.eventhost.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void addUser(String firstName, String lastName, String userName, String password, String email) {
        User user = new User(firstName, lastName, userName, password, email);
        userRepository.save(user);
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    public User getUser(Integer id) {
        return userRepository.getOne(id);
    }

    public List<User> getallUsers() {
        List<User> users = userRepository.findAll();
        return users;
    }
}
