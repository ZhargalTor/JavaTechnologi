package model.equipment;

public class Gloves extends Equipment {
    private String gloveType;
    private transient boolean hasKnuckleProtection;

    public Gloves(String name, String brand, double weight, double price,
                  String material, String color, String gloveType, boolean hasKnuckleProtection) {
        super(name, brand, weight, price, material, color);
        this.gloveType = gloveType;
        this.hasKnuckleProtection = hasKnuckleProtection;
    }

    public String getGloveType() { return gloveType; }
    public boolean hasKnuckleProtection() { return hasKnuckleProtection; }

    @Override
    public String getType() { return "Перчатки"; }

    @Override
    public String getDescription() {
        return String.format("%s перчатки, тип: %s", brand, gloveType);
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Тип: %-10s", gloveType);
    }
}