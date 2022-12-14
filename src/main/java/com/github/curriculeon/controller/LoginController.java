package com.github.curriculeon.controller;

import com.github.curriculeon.model.LoginResponse;
import com.github.curriculeon.model.User;
import com.github.curriculeon.repository.UserRepository;
import com.github.curriculeon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RequestMapping(value = "/login-controller")
@RestController
public class LoginController {

    @Autowired
    private UserRepository userRepository;
    private User currentLoggedInUser;
    private UserService service;

    @Autowired
    public LoginController(UserService service) {
        this.service = service;
    }

    @PostMapping("/login")
    public ResponseEntity<Object> loginUser(@RequestBody Map<String, String> data) {
        //we get the data that was entered in the login form
        String username = data.get("username");
        String password = data.get("password");

        User user = userRepository.findByUsernameAndPassword(username, password); //Queries the database for matching user
        if (user != null) {
            this.currentLoggedInUser = user;
            //User was found, make user the currentLoggedIn user and return a success response.
            return new ResponseEntity<>(new LoginResponse(true, user), HttpStatus.OK);
        } else {
            //No matching user was found, return a failure response
            return new ResponseEntity<>(new LoginResponse(false, null), HttpStatus.OK);
        }

    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<User> getCurrentUser(){
        return new ResponseEntity<>(this.currentLoggedInUser, HttpStatus.OK);
    }

    @RequestMapping(value = "/read-all", method = RequestMethod.GET)
    public ResponseEntity<List<User>> readAll() {
        List<User> responseBody = service.readAll();
        ResponseEntity responseEntity = new ResponseEntity<>(responseBody, HttpStatus.OK);
        return responseEntity;
    }

//    @RequestMapping(value = "/login/{name}", method = RequestMethod.PUT)
//    public ResponseEntity<User> login(@PathVariable Long id, @RequestBody User user) {
//        System.out.println("Logging in..");
//        this.currentLoggedInUser = new User(id, user);
//        return new ResponseEntity<>(currentLoggedInUser, HttpStatus.OK);
//    }

}