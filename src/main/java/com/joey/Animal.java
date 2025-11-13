package com.joey;

import java.time.Instant;

public class Animal {
    private String givenName;
    private int age;
    private Instant timestampReceived;


    public Animal(String givenName, int age, Instant timestampReceived) {
        this.givenName = givenName;
        this.age = age;
        this.timestampReceived = timestampReceived;
    }


    public String toString() {
        return String.format("%s (%s, %d year(s) old, arrived %s)", this.getGivenName(), this.getClass().getSimpleName(), this.getAge(), this.getTimestampReceived());
    }


    public String getGivenName() {
        return this.givenName;
    }

    public int getAge() {
        return this.age;
    }

    public Instant getTimestampReceived() {
        return this.timestampReceived;
    }

    public String getSpecies() {
        return null;
    }


    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setTimestampReceived(Instant timestampReceived) {
        this.timestampReceived = timestampReceived;
    }
}