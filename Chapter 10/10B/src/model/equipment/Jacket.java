package model.equipment;

public class Jacket extends Equipment {
    private boolean hasProtection;
    private transient boolean isWaterproof;

    public Jacket(String name, String brand, double weight, double price,
                  String material, String color, boolean hasProtection, boolean isWaterproof) {
        super(name, brand, weight, price, material, color);
        this.hasProtection = hasProtection;
        this.isWaterproof = isWaterproof;
    }

    public boolean hasProtection() { return hasProtection; }
    public boolean isWaterproof() { return isWaterproof; }

    @Override
    public String getType() { return "Куртка"; }

    @Override
    public String getDescription() {
        return String.format("%s куртка, защита: %s", brand, hasProtection ? "есть" : "нет");
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Защита: %-4s", hasProtection ? "да" : "нет");
    }
}