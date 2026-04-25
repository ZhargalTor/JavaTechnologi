package model.equipment;

public class Helmet extends Equipment {
    private transient String helmetType;
    private String visorType;

    public Helmet(String name, String brand, double weight, double price,
                  String material, String color, String helmetType, String visorType) {
        super(name, brand, weight, price, material, color);
        this.helmetType = helmetType;
        this.visorType = visorType;
    }

    public String getHelmetType() { return helmetType; }
    public String getVisorType() { return visorType; }

    @Override
    public String getType() { return "Шлем"; }

    @Override
    public String getDescription() {
        return String.format("%s шлем, тип: %s, визор: %s", brand, helmetType, visorType);
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Тип: %-10s", helmetType);
    }
}