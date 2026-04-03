public class Bicycle implements Vehicle {
    private String registrationNumber;
    private String brand;
    private String model;
    private String vinNumber;
    private String owner;
    private String powerType;
    private int gearCount;
    private boolean hasLights;

    public Bicycle(String registrationNumber, String brand, String model,
                   String vinNumber, String owner, String powerType,
                   int gearCount, boolean hasLights) {
        this.registrationNumber = registrationNumber;
        this.brand = brand;
        this.model = model;
        this.vinNumber = vinNumber;
        this.owner = owner;
        this.powerType = powerType;
        this.gearCount = gearCount;
        this.hasLights = hasLights;
    }

    @Override
    public String getRegistrationNumber() { return registrationNumber; }
    @Override
    public void setRegistrationNumber(String number) { this.registrationNumber = number; }

    @Override
    public String getBrand() { return brand; }
    @Override
    public void setBrand(String brand) { this.brand = brand; }

    @Override
    public String getModel() { return model; }
    @Override
    public void setModel(String model) { this.model = model; }

    @Override
    public String getVinNumber() { return vinNumber; }
    @Override
    public void setVinNumber(String vin) { this.vinNumber = vin; }

    @Override
    public String getOwner() { return owner; }
    @Override
    public void setOwner(String owner) { this.owner = owner; }

    @Override
    public String getPowerType() { return powerType; }
    @Override
    public void setPowerType(String powerType) { this.powerType = powerType; }

    public int getGearCount() { return gearCount; }
    public void setGearCount(int gearCount) { this.gearCount = gearCount; }

    public boolean hasLights() { return hasLights; }
    public void setHasLights(boolean hasLights) { this.hasLights = hasLights; }

    @Override
    public void refuel() {
        System.out.println("Велосипед " + brand + " " + model + " - человек заправился энергией (перекусил)");
    }

    @Override
    public void repair() {
        System.out.println("Велосипед " + brand + " " + model + " отремонтирован (замена камеры, настройка тормозов)");
    }

    @Override
    public void service() {
        System.out.println("Велосипед " + brand + " " + model + " прошёл обслуживание (смазка цепи, подкачка колёс)");
    }

    @Override
    public void technicalInspection() {
        System.out.println("Велосипед " + brand + " " + model + " прошёл техосмотр (проверка тормозов и света)");
    }

    @Override
    public void displayInfo() {
        System.out.println("\n ВЕЛОСИПЕД ");
        System.out.println("Рег. номер: " + registrationNumber);
        System.out.println("Марка: " + brand);
        System.out.println("Модель: " + model);
        System.out.println("VIN: " + vinNumber);
        System.out.println("Владелец: " + owner);
        System.out.println("Привод: " + powerType);
        System.out.println("Кол-во скоростей: " + gearCount);
        System.out.println("Фары: " + (hasLights ? "есть" : "нет"));
    }
}