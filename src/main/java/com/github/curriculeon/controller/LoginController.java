package com.github.curriculeon.controller;

import com.github.curriculeon.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*")
@RequestMapping(value = "/login-controller")
@RestController
public class LoginController {
    private User currentLoggedInUser;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<User> getCurrentUser(){
        return new ResponseEntity<>(this.currentLoggedInUser, HttpStatus.OK);
    }

    @RequestMapping(value = "/login/{name}", method = RequestMethod.PUT)
    public ResponseEntity<User> login(@PathVariable String name) {
        System.out.println("Logging in..");
        this.currentLoggedInUser = new User(name);
        ResponseEntity<User> response = new ResponseEntity<>(currentLoggedInUser, HttpStatus.OK);
        return response;
    }

}