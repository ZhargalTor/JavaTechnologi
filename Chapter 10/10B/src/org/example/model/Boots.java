package org.example.model;

public class Boots extends Equipment {

    public Boots(String name, double price, double weight) {
        super(name, price, weight);
    }

    @Override
    public String getType() {
        return "Ботинки";
    }
}