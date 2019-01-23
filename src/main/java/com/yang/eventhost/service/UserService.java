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

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    public User getUser(Integer id) {
        return userRepository.getOne(id);
    }

    public User findbyEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<User> getallUsers() {
        List<User> users = userRepository.findAll();
        return users;
    }
}
