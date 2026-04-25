package model.equipment;

public class Pants extends Equipment {
    private boolean hasProtection;
    private transient boolean hasThermalLining;

    public Pants(String name, String brand, double weight, double price,
                 String material, String color, boolean hasProtection, boolean hasThermalLining) {
        super(name, brand, weight, price, material, color);
        this.hasProtection = hasProtection;
        this.hasThermalLining = hasThermalLining;
    }

    public boolean hasProtection() { return hasProtection; }
    public boolean hasThermalLining() { return hasThermalLining; }

    @Override
    public String getType() { return "Штаны"; }

    @Override
    public String getDescription() {
        return String.format("%s штаны, защита: %s", brand, hasProtection ? "есть" : "нет");
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Защита: %-4s", hasProtection ? "да" : "нет");
    }
}