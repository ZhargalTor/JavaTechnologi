package model.equipment;

public class Boots extends Equipment {
    private String bootType;
    private double shaftHeight;
    private boolean hasReinforcedAnkle;
    private boolean hasSteelToe;

    public Boots(String name, String brand, double weight, double price, String material, String color,
                 String bootType, double shaftHeight, boolean hasReinforcedAnkle, boolean hasSteelToe) {
        super(name, brand, weight, price, material, color);
        this.bootType = bootType;
        this.shaftHeight = shaftHeight;
        this.hasReinforcedAnkle = hasReinforcedAnkle;
        this.hasSteelToe = hasSteelToe;
    }

    public String getBootType() { return bootType; }
    public void setBootType(String bootType) { this.bootType = bootType; }
    public double getShaftHeight() { return shaftHeight; }
    public void setShaftHeight(double shaftHeight) { this.shaftHeight = shaftHeight; }
    public boolean hasReinforcedAnkle() { return hasReinforcedAnkle; }
    public void setHasReinforcedAnkle(boolean hasReinforcedAnkle) { this.hasReinforcedAnkle = hasReinforcedAnkle; }
    public boolean hasSteelToe() { return hasSteelToe; }
    public void setHasSteelToe(boolean hasSteelToe) { this.hasSteelToe = hasSteelToe; }

    @Override
    public String getType() { return "Ботинки"; }

    @Override
    public String getDescription() {
        return String.format("%s ботинки, тип: %s, высота: %.1f см, усиление щиколотки: %s, стальной носок: %s",
                brand, bootType, shaftHeight, hasReinforcedAnkle ? "есть" : "нет", hasSteelToe ? "есть" : "нет");
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Тип: %-10s | Высота: %4.1f см | Усиление: %-4s | Сталь: %-4s",
                bootType, shaftHeight, hasReinforcedAnkle ? "да" : "нет", hasSteelToe ? "да" : "нет");
    }
}