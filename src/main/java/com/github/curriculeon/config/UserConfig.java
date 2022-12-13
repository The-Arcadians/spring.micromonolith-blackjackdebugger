package com.github.curriculeon.config;

import com.github.curriculeon.model.User;
import com.github.curriculeon.model.Winner;
import com.github.curriculeon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class UserConfig {

    @Autowired
    private UserService service;

    @PostConstruct
    public void setup(){
        service.create(new User(1L, "Randy", "Curriculeon"));
        service.create(new User(2L, "Leon", "Curriculeon"));
        service.create(new User(3L, "Brent", "Curriculeon"));
        service.create(new User(4L, "Eric", "Curriculeon"));


    }
}