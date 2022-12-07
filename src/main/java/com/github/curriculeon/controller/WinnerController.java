package com.github.curriculeon.controller;

import com.github.curriculeon.model.Person;
import com.github.curriculeon.model.Winner;
import com.github.curriculeon.service.WinnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping(value = "/winner-controller")
@RestController
public class WinnerController {

    private WinnerService service;


    @Autowired
    public WinnerController(WinnerService service) {
        this.service = service;
    }


    @RequestMapping(value = "/create-default", method = RequestMethod.POST)
    public ResponseEntity<Winner> create() {
        Winner responseBody = service.create(new Winner(0L, "Leon", 0));
        ResponseEntity responseEntity = new ResponseEntity<>(responseBody, HttpStatus.OK);
        return responseEntity;
    }


    @RequestMapping(value = "/get-bean", method = RequestMethod.GET)
    @Qualifier("default-winner")
    public ResponseEntity<Winner> getWinnerBean(Winner winner) {
        return new ResponseEntity<>(winner, HttpStatus.OK);
    }


    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public ResponseEntity<Winner> create(@RequestBody Winner winner) {
        Winner responseBody = service.create(winner);
        ResponseEntity responseEntity = new ResponseEntity<>(responseBody, HttpStatus.OK);
        return responseEntity;
    }


    @RequestMapping(value = "/read", method = RequestMethod.GET)
    public ResponseEntity<Winner> read(@PathVariable Long id) {
        Winner responseBody = service.read(id);
        ResponseEntity responseEntity = new ResponseEntity<>(responseBody, HttpStatus.OK);
        return responseEntity;
    }


    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<Winner> update(@PathVariable Long id, @RequestBody Winner winner) {
        Winner responseBody = service.update(id, winner);
        ResponseEntity responseEntity = new ResponseEntity<>(responseBody, HttpStatus.OK);
        return responseEntity;
    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Person> delete(@PathVariable Long id) {
        Winner responseBody = service.delete(id);
        ResponseEntity responseEntity = new ResponseEntity<>(responseBody, HttpStatus.OK);
        return responseEntity;
    }


    @RequestMapping(value = "/read-all", method = RequestMethod.GET)
    public ResponseEntity<List<Winner>> readAll() {
        List<Winner> responseBody = service.readAll();
        ResponseEntity responseEntity = new ResponseEntity<>(responseBody, HttpStatus.OK);
        return responseEntity;
    }


}
