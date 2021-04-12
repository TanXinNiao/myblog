package com.greedybird.springboottest.service;

import com.greedybird.springboottest.entity.User;
import com.greedybird.springboottest.reposity.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {
    @Autowired
    private UserRepository userRepository;

    public boolean verifyLogin(User user){
        List<User> userList = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        return userList.size() > 0;
    }
}
