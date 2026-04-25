package org.example.model;

public class Helmet extends Equipment {

    public Helmet(String name, double price, double weight) {
        super(name, price, weight);
    }

    @Override
    public String getType() {
        return "Шлем";
    }
}