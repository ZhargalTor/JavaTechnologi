package org.example.model;

public class Jacket extends Equipment {

    public Jacket(String name, double price, double weight) {
        super(name, price, weight);
    }

    @Override
    public String getType() {
        return "Куртка";
    }
}