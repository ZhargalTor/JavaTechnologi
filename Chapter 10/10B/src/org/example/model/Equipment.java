package org.example.model;

import java.io.Serializable;

public abstract class Equipment implements Serializable {
    private String name;
    private double price;
    private double weight;

    // static поле (не сериализуется)
    public static String currency = "EUR";

    // transient поле (не сериализуется)
    private transient String note;

    public Equipment(String name, double price, double weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    public double getPrice() {
        return price;
    }

    public double getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    public abstract String getType();

    @Override
    public String toString() {
        return getType() + ": " + name +
                " | цена=" + price +
                " | вес=" + weight;
    }
}