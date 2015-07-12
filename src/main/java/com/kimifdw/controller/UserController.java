package com.kimifdw.controller;

import com.kimifdw.model.User;
import com.kimifdw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * Created by kimiyu on 15/7/12.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/name")
    @ResponseBody
    public User findByName(String name){
        return userService.getUserByUserName(name);
    }

    @RequestMapping("/save")
    @ResponseBody
    public String save(@Valid User user){
        userService.saveUser(user);
        return "ok";
    }
}
