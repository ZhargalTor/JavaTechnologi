package model.equipment;

public class Jacket extends Equipment {
    private boolean hasProtection;
    private boolean isWaterproof;
    private boolean hasVentilation;

    public Jacket(String name, String brand, double weight, double price, String material, String color,
                  boolean hasProtection, boolean isWaterproof, boolean hasVentilation) {
        super(name, brand, weight, price, material, color);
        this.hasProtection = hasProtection;
        this.isWaterproof = isWaterproof;
        this.hasVentilation = hasVentilation;
    }

    public boolean hasProtection() { return hasProtection; }
    public void setHasProtection(boolean hasProtection) { this.hasProtection = hasProtection; }
    public boolean isWaterproof() { return isWaterproof; }
    public void setWaterproof(boolean waterproof) { isWaterproof = waterproof; }
    public boolean hasVentilation() { return hasVentilation; }
    public void setHasVentilation(boolean hasVentilation) { this.hasVentilation = hasVentilation; }

    @Override
    public String getType() { return "Куртка"; }

    @Override
    public String getDescription() {
        return String.format("%s куртка, защита: %s, водонепроницаемая: %s, вентиляция: %s",
                brand, hasProtection ? "есть" : "нет", isWaterproof ? "да" : "нет", hasVentilation ? "да" : "нет");
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Защита: %-4s | Водостойк: %-4s | Вентиляция: %-4s",
                hasProtection ? "да" : "нет", isWaterproof ? "да" : "нет", hasVentilation ? "да" : "нет");
    }
}