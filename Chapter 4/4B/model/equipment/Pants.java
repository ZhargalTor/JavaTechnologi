package model.equipment;

public class Pants extends Equipment {
    private boolean hasProtection;
    private boolean isWaterproof;
    private boolean hasThermalLining;

    public Pants(String name, String brand, double weight, double price, String material, String color,
                 boolean hasProtection, boolean isWaterproof, boolean hasThermalLining) {
        super(name, brand, weight, price, material, color);
        this.hasProtection = hasProtection;
        this.isWaterproof = isWaterproof;
        this.hasThermalLining = hasThermalLining;
    }

    public boolean hasProtection() { return hasProtection; }
    public void setHasProtection(boolean hasProtection) { this.hasProtection = hasProtection; }
    public boolean isWaterproof() { return isWaterproof; }
    public void setWaterproof(boolean waterproof) { isWaterproof = waterproof; }
    public boolean hasThermalLining() { return hasThermalLining; }
    public void setHasThermalLining(boolean hasThermalLining) { this.hasThermalLining = hasThermalLining; }

    @Override
    public String getType() { return "Штаны"; }

    @Override
    public String getDescription() {
        return String.format("%s штаны, защита: %s, водонепроницаемые: %s, термоподкладка: %s",
                brand, hasProtection ? "есть" : "нет", isWaterproof ? "да" : "нет", hasThermalLining ? "да" : "нет");
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Защита: %-4s | Водостойк: %-4s | Термо: %-4s",
                hasProtection ? "да" : "нет", isWaterproof ? "да" : "нет", hasThermalLining ? "да" : "нет");
    }
}