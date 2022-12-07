package com.github.curriculeon.service;

import com.github.curriculeon.model.Winner;
import com.github.curriculeon.repository.WinnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WinnerService {

    private WinnerRepository repository;

    @Autowired
    public WinnerService(WinnerRepository repository) {this.repository = repository; }

    public Winner create(Winner winner) {
        Winner winnerCreated = repository.save(winner);
        return winnerCreated;
    }

    public Winner read(Long id) {
        Optional<Winner> potentialWinner = repository.findById(id);
        Winner winner = potentialWinner.get();
        return winner;
    }

    public Winner update(Long id, Winner winner) {
        Winner winnerInDataBase = read(id);
        String newName = winner.getName();
        int numberOfWins = winner.getNumberOfWins();

        winnerInDataBase.setName(newName);
        winnerInDataBase.setNumberOfWins(numberOfWins);
        repository.save(winnerInDataBase);
        return winnerInDataBase;
    }

    public Winner delete(Long id) {
        Winner winner = read(id);
        repository.delete(winner);
        return winner;
    }

    public List<Winner> readAll() {
        List<Winner> winnerList = new ArrayList<>();
        repository.findAll().forEach(winnerList::add);
        return winnerList;
    }

}
