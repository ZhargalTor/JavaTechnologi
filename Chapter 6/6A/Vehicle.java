public interface Vehicle {
    String getRegistrationNumber();
    void setRegistrationNumber(String number);

    String getBrand();
    void setBrand(String brand);

    String getModel();
    void setModel(String model);

    String getVinNumber();
    void setVinNumber(String vin);

    String getOwner();
    void setOwner(String owner);

    String getPowerType();
    void setPowerType(String powerType);

    void refuel();
    void repair();
    void service();
    void technicalInspection();

    void displayInfo();
}