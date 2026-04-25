package model.equipment;

public class Protection extends Equipment {
    private String protectionType;
    private transient String protectionLevel;

    public Protection(String name, String brand, double weight, double price,
                      String material, String color, String protectionType, String protectionLevel) {
        super(name, brand, weight, price, material, color);
        this.protectionType = protectionType;
        this.protectionLevel = protectionLevel;
    }

    public String getProtectionType() { return protectionType; }
    public String getProtectionLevel() { return protectionLevel; }

    @Override
    public String getType() { return "Защита"; }

    @Override
    public String getDescription() {
        return String.format("%s %s, уровень: %s", brand, protectionType, protectionLevel);
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Тип: %-12s", protectionType);
    }
}