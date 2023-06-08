package com.example.btcanhan.service;

import com.example.btcanhan.entity.User;
import com.example.btcanhan.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private IUserRepository userRepository;
    public void save(User user){
        userRepository.save(user);
    }
    public User getUserByUsername(String name){
        return userRepository.findByUsername(name);
    }

}
