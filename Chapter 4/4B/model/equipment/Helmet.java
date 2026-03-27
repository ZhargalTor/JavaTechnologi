package model.equipment;

public class Helmet extends Equipment {
    private String helmetType;
    private String visorType;
    private boolean hasInternalSunVisor;

    public Helmet(String name, String brand, double weight, double price, String material, String color,
                  String helmetType, String visorType, boolean hasInternalSunVisor) {
        super(name, brand, weight, price, material, color);
        this.helmetType = helmetType;
        this.visorType = visorType;
        this.hasInternalSunVisor = hasInternalSunVisor;
    }

    public String getHelmetType() { return helmetType; }
    public void setHelmetType(String helmetType) { this.helmetType = helmetType; }
    public String getVisorType() { return visorType; }
    public void setVisorType(String visorType) { this.visorType = visorType; }
    public boolean hasInternalSunVisor() { return hasInternalSunVisor; }
    public void setHasInternalSunVisor(boolean hasInternalSunVisor) { this.hasInternalSunVisor = hasInternalSunVisor; }

    @Override
    public String getType() { return "Шлем"; }

    @Override
    public String getDescription() {
        return String.format("%s шлем, тип: %s, визор: %s, внутренний козырек: %s",
                brand, helmetType, visorType, hasInternalSunVisor ? "есть" : "нет");
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Тип: %-10s | Визор: %-8s | Козырек: %s",
                helmetType, visorType, hasInternalSunVisor ? "да" : "нет");
    }
}