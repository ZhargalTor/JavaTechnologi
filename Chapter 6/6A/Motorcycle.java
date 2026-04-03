public class Motorcycle implements Vehicle {
    private String registrationNumber;
    private String brand;
    private String model;
    private String vinNumber;
    private String owner;
    private String powerType;
    private int engineVolume;
    private boolean hasSidecar;

    public Motorcycle(String registrationNumber, String brand, String model,
                      String vinNumber, String owner, String powerType,
                      int engineVolume, boolean hasSidecar) {
        this.registrationNumber = registrationNumber;
        this.brand = brand;
        this.model = model;
        this.vinNumber = vinNumber;
        this.owner = owner;
        this.powerType = powerType;
        this.engineVolume = engineVolume;
        this.hasSidecar = hasSidecar;
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

    public int getEngineVolume() { return engineVolume; }
    public void setEngineVolume(int engineVolume) { this.engineVolume = engineVolume; }

    public boolean hasSidecar() { return hasSidecar; }
    public void setHasSidecar(boolean hasSidecar) { this.hasSidecar = hasSidecar; }

    @Override
    public void refuel() {
        System.out.println("Мотоцикл " + brand + " " + model + " заправлен бензином");
    }

    @Override
    public void repair() {
        System.out.println("Мотоцикл " + brand + " " + model + " отремонтирован в мотомастерской");
    }

    @Override
    public void service() {
        System.out.println("Мотоцикл " + brand + " " + model + " прошёл обслуживание (регулировка клапанов, замена масла)");
    }

    @Override
    public void technicalInspection() {
        System.out.println("Мотоцикл " + brand + " " + model + " прошёл техосмотр (проверка выхлопа и тормозов)");
    }

    @Override
    public void displayInfo() {
        System.out.println("\n МОТОЦИКЛ ");
        System.out.println("Рег. номер: " + registrationNumber);
        System.out.println("Марка: " + brand);
        System.out.println("Модель: " + model);
        System.out.println("VIN: " + vinNumber);
        System.out.println("Владелец: " + owner);
        System.out.println("Двигатель: " + powerType);
        System.out.println("Объём двигателя: " + engineVolume + " см³");
        System.out.println("Коляска: " + (hasSidecar ? "есть" : "нет"));
    }
}