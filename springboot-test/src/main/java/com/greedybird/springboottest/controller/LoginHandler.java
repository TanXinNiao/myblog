package com.greedybird.springboottest.controller;

import com.greedybird.springboottest.entity.User;
import com.greedybird.springboottest.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
public class LoginHandler {
    @Autowired
    private LoginService loginService;

    @PostMapping("/loginVerify")
    public String loginVerify(@RequestBody User user){
        System.out.println(user.getUsername() + ' ' + user.getPassword());
        boolean verify = loginService.verifyLogin(user);
        if (verify){
            return "success";
        }
        else{
            return "failure";
        }
    }
}
