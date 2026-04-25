package model.equipment;

public class Boots extends Equipment {
    private String bootType;
    private transient boolean hasReinforcedAnkle;

    public Boots(String name, String brand, double weight, double price,
                 String material, String color, String bootType, boolean hasReinforcedAnkle) {
        super(name, brand, weight, price, material, color);
        this.bootType = bootType;
        this.hasReinforcedAnkle = hasReinforcedAnkle;
    }

    public String getBootType() { return bootType; }
    public boolean hasReinforcedAnkle() { return hasReinforcedAnkle; }

    @Override
    public String getType() { return "Ботинки"; }

    @Override
    public String getDescription() {
        return String.format("%s ботинки, тип: %s", brand, bootType);
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Тип: %-10s", bootType);
    }
}