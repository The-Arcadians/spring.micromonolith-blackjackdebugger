package com.github.curriculeon.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Winner {
    @Id
    private String name;

    private int numberOfWins;

    public Winner() {
    }



    public Winner(long l, String brent, int i) {
        this.name = name;
        this.numberOfWins = numberOfWins;

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
