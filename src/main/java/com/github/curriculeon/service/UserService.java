package com.github.curriculeon.service;

import com.github.curriculeon.model.User;
import com.github.curriculeon.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User create(User user) {
        User userCreated = repository.save(user);
        return userCreated;
    }

    public User read(Long id) {
        Optional<User> potentialUser = repository.findById(id);
        User user = potentialUser.get();
        return user;
    }

    public User update(Long id, User user) {
        User personInDataBase = read(id);
        String newUsername = user.getUsername();

        personInDataBase.setUsername(newUsername);
        repository.save(personInDataBase);
        return personInDataBase;
    }

    public User delete(Long id) {
        User user = read(id);
        repository.delete(user);
        return user;
    }

    public List<User> readAll() {
        List<User> userList = new ArrayList<>();
        repository.findAll().forEach(userList::add);
        return userList;
    }

//    public User read(Long id) {
//        Optional<User> user= repository.findById(id);
//        User currentUser = user.get();
//        return currentUser;
//    }
}
