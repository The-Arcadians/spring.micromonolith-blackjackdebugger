package com.github.curriculeon.config;

import com.github.curriculeon.model.User;
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
        service.create(new User("Randy", "Curriculeon"));
        service.create(new User("Leon", "Curriculeon"));
        service.create(new User("Brent", "Curriculeon"));
        service.create(new User("Eric", "Curriculeon"));
    }
}