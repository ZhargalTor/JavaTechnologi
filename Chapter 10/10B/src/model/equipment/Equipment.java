package model.equipment;

import java.io.Serializable;
import java.util.Objects;

public abstract class Equipment implements Serializable {
    private static final long serialVersionUID = 1L;
    private static int totalItems = 0;

    protected String name;
    protected String brand;
    protected double weight;
    protected double price;
    protected String material;
    protected String color;

    public Equipment(String name, String brand, double weight, double price, String material, String color) {
        this.name = name;
        this.brand = brand;
        this.weight = weight;
        this.price = price;
        this.material = material;
        this.color = color;
        totalItems++;
    }

    public static int getTotalItems() {
        return totalItems;
    }

    public static void resetTotalItems() {
        totalItems = 0;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }
    public double getWeight() { return weight; }
    public void setWeight(double weight) { this.weight = weight; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public String getMaterial() { return material; }
    public void setMaterial(String material) { this.material = material; }
    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public abstract String getType();
    public abstract String getDescription();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equipment equipment = (Equipment) o;
        return Double.compare(weight, equipment.weight) == 0 &&
                Double.compare(price, equipment.price) == 0 &&
                Objects.equals(name, equipment.name) &&
                Objects.equals(brand, equipment.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, brand, weight, price);
    }

    @Override
    public String toString() {
        return String.format("%-12s | %-20s | %-15s | Вес: %5.2f кг | Цена: %8.2f руб.",
                getType(), name, brand, weight, price);
    }
}