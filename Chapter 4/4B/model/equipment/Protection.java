package model.equipment;

public class Protection extends Equipment {
    private String protectionType;
    private String protectionLevel;
    private String certification;

    public Protection(String name, String brand, double weight, double price, String material, String color,
                      String protectionType, String protectionLevel, String certification) {
        super(name, brand, weight, price, material, color);
        this.protectionType = protectionType;
        this.protectionLevel = protectionLevel;
        this.certification = certification;
    }

    public String getProtectionType() { return protectionType; }
    public void setProtectionType(String protectionType) { this.protectionType = protectionType; }
    public String getProtectionLevel() { return protectionLevel; }
    public void setProtectionLevel(String protectionLevel) { this.protectionLevel = protectionLevel; }
    public String getCertification() { return certification; }
    public void setCertification(String certification) { this.certification = certification; }

    @Override
    public String getType() { return "Защита"; }

    @Override
    public String getDescription() {
        return String.format("%s %s, уровень: %s, сертификация: %s",
                brand, protectionType, protectionLevel, certification);
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Тип: %-12s | Уровень: %-7s | Сертиф: %s",
                protectionType, protectionLevel, certification);
    }
}