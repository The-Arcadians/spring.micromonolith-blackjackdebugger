package com.github.curriculeon.config;

import com.github.curriculeon.model.Winner;
import com.github.curriculeon.service.WinnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class WinnerConfig {

    @Autowired
    private WinnerService service;

    @PostConstruct
    public void setup(){
        service.create(new Winner(1L, "Brent", 7));
        service.create(new Winner(2L, "Eric", 6));
        service.create(new Winner(3L, "Leon", 4));
        service.create(new Winner(4L, "Randy", 3));


    }
}
