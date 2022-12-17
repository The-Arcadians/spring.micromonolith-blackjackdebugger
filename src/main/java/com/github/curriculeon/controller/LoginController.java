package com.github.curriculeon.controller;


import com.github.curriculeon.model.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RequestMapping(value = "/login-controller")
@RestController
public class LoginController {
    private Person currentLoggedInUser;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<Person> getCurrentUser() {
        return new ResponseEntity<>(this.currentLoggedInUser, HttpStatus.OK);
    }

    @RequestMapping(value = "/login/{name}", method = RequestMethod.PUT)
    public ResponseEntity<Person> login(@PathVariable String name) {
        System.out.println("Attempting to log in...");
        this.currentLoggedInUser = new Person(null, name, null);
        ResponseEntity<Person> response = new ResponseEntity<>(currentLoggedInUser, HttpStatus.OK);
        return response;
    }
}