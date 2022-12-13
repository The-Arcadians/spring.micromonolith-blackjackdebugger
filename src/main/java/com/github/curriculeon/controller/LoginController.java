package com.github.curriculeon.controller;

import com.github.curriculeon.model.Person;
import com.github.curriculeon.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping(value = "/login-controller")
@RestController
public class LoginController {

    private User currentLoggedInUser;

    public ResponseEntity<String> getCurrentUser(){
        return new ResponseEntity<>(this.currentLoggedInUser, HttpStatus.OK);
    }

    @RequestMapping(value = "/login/{name}", method = RequestMethod.PUT)
    public ResponseEntity<Person> login(@PathVariable String name) {
        this.currentLoggedInUser = name;
        ResponseEntity<User> responseEntity = new ResponseEntity<>(currentLoggedInUser, HttpStatus.OK);
        return responseEntity;
    }

}