package com.joey;

import java.time.Instant;

public class Dog extends Animal {
    private String species;

    public Dog(String givenName, int age, Instant timestampReceived, String species) {
        super(givenName, age, timestampReceived);
        this.species = species;
    }


    @Override public String getSpecies() {
        return this.species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }
}