package com.github.curriculeon.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Winner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int rank;

    private Long id;

    private String name;

    private int numberOfWins;

    public Winner() {
    }


    public Winner(int rank,Long id, String name, int numberOfWins) {
        this.rank = rank;
        this.id = id;
        this.name = name;
        this.numberOfWins = numberOfWins;

    }


    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfWins() {
        return numberOfWins;
    }

    public void setNumberOfWins(int numberOfWins) {
        this.numberOfWins = numberOfWins;
    }


}
