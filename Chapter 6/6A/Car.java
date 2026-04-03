public class Car implements Vehicle {
    private String registrationNumber;
    private String brand;
    private String model;
    private String vinNumber;
    private String owner;
    private String powerType;
    private int doorCount;
    private boolean hasAirConditioning;

    public Car(String registrationNumber, String brand, String model,
               String vinNumber, String owner, String powerType,
               int doorCount, boolean hasAirConditioning) {
        this.registrationNumber = registrationNumber;
        this.brand = brand;
        this.model = model;
        this.vinNumber = vinNumber;
        this.owner = owner;
        this.powerType = powerType;
        this.doorCount = doorCount;
        this.hasAirConditioning = hasAirConditioning;
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

    public int getDoorCount() { return doorCount; }
    public void setDoorCount(int doorCount) { this.doorCount = doorCount; }

    public boolean hasAirConditioning() { return hasAirConditioning; }
    public void setHasAirConditioning(boolean hasAirConditioning) { this.hasAirConditioning = hasAirConditioning; }

    @Override
    public void refuel() {
        System.out.println("Автомобиль " + brand + " " + model + " заправлен бензином/дизелем/электричеством");
    }

    @Override
    public void repair() {
        System.out.println("Автомобиль " + brand + " " + model + " отремонтирован в автосервисе");
    }

    @Override
    public void service() {
        System.out.println("Автомобиль " + brand + " " + model + " прошёл плановое ТО (замена масла, фильтров)");
    }

    @Override
    public void technicalInspection() {
        System.out.println("Автомобиль " + brand + " " + model + " прошёл техосмотр. Диагностическая карта выдана");
    }

    @Override
    public void displayInfo() {
        System.out.println("\n АВТОМОБИЛЬ ");
        System.out.println("Рег. номер: " + registrationNumber);
        System.out.println("Марка: " + brand);
        System.out.println("Модель: " + model);
        System.out.println("VIN: " + vinNumber);
        System.out.println("Владелец: " + owner);
        System.out.println("Двигатель: " + powerType);
        System.out.println("Кол-во дверей: " + doorCount);
        System.out.println("Кондиционер: " + (hasAirConditioning ? "да" : "нет"));
    }
}