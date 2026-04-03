public class QuadBike implements Vehicle {
    private String registrationNumber;
    private String brand;
    private String model;
    private String vinNumber;
    private String owner;
    private String powerType;
    private int engineVolume;
    private boolean hasWinch;

    public QuadBike(String registrationNumber, String brand, String model,
                    String vinNumber, String owner, String powerType,
                    int engineVolume, boolean hasWinch) {
        this.registrationNumber = registrationNumber;
        this.brand = brand;
        this.model = model;
        this.vinNumber = vinNumber;
        this.owner = owner;
        this.powerType = powerType;
        this.engineVolume = engineVolume;
        this.hasWinch = hasWinch;
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

    public boolean hasWinch() { return hasWinch; }
    public void setHasWinch(boolean hasWinch) { this.hasWinch = hasWinch; }

    @Override
    public void refuel() {
        System.out.println("Квадроцикл " + brand + " " + model + " заправлен бензином");
    }

    @Override
    public void repair() {
        System.out.println("Квадроцикл " + brand + " " + model + " отремонтирован в сервисном центре");
    }

    @Override
    public void service() {
        System.out.println("Квадроцикл " + brand + " " + model + " прошёл обслуживание (чистка воздушного фильтра, замена масла)");
    }

    @Override
    public void technicalInspection() {
        System.out.println("Квадроцикл " + brand + " " + model + " прошёл техосмотр (проверка подвески и тормозов)");
    }

    @Override
    public void displayInfo() {
        System.out.println("\n КВАДРОЦИКЛ ");
        System.out.println("Рег. номер: " + registrationNumber);
        System.out.println("Марка: " + brand);
        System.out.println("Модель: " + model);
        System.out.println("VIN: " + vinNumber);
        System.out.println("Владелец: " + owner);
        System.out.println("Двигатель: " + powerType);
        System.out.println("Объём двигателя: " + engineVolume + " см³");
        System.out.println("Лебёдка: " + (hasWinch ? "есть" : "нет"));
    }
}