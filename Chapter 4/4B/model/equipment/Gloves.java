package model.equipment;

public class Gloves extends Equipment {
    private String gloveType;
    private boolean hasKnuckleProtection;
    private boolean isTouchscreenCompatible;

    public Gloves(String name, String brand, double weight, double price, String material, String color,
                  String gloveType, boolean hasKnuckleProtection, boolean isTouchscreenCompatible) {
        super(name, brand, weight, price, material, color);
        this.gloveType = gloveType;
        this.hasKnuckleProtection = hasKnuckleProtection;
        this.isTouchscreenCompatible = isTouchscreenCompatible;
    }

    public String getGloveType() { return gloveType; }
    public void setGloveType(String gloveType) { this.gloveType = gloveType; }
    public boolean hasKnuckleProtection() { return hasKnuckleProtection; }
    public void setHasKnuckleProtection(boolean hasKnuckleProtection) { this.hasKnuckleProtection = hasKnuckleProtection; }
    public boolean isTouchscreenCompatible() { return isTouchscreenCompatible; }
    public void setTouchscreenCompatible(boolean touchscreenCompatible) { isTouchscreenCompatible = touchscreenCompatible; }

    @Override
    public String getType() { return "Перчатки"; }

    @Override
    public String getDescription() {
        return String.format("%s перчатки, тип: %s, защита костяшек: %s, сенсорный экран: %s",
                brand, gloveType, hasKnuckleProtection ? "есть" : "нет", isTouchscreenCompatible ? "да" : "нет");
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Тип: %-10s | Защита: %-4s | Сенсор: %-4s",
                gloveType, hasKnuckleProtection ? "да" : "нет", isTouchscreenCompatible ? "да" : "нет");
    }
}