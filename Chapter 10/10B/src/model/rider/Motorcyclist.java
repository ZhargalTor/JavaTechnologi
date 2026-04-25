package model.rider;

import model.equipment.Equipment;
import java.io.Serializable;
import java.util.*;

public class Motorcyclist implements Serializable {
    private static final long serialVersionUID = 1L;
    private static int totalMotorcyclists = 0;

    private String name;
    private int age;
    private String licenseCategory;
    private List<Equipment> equipmentList;
    private transient String temporaryNote;

    public Motorcyclist(String name, int age, String licenseCategory) {
        this.name = name;
        this.age = age;
        this.licenseCategory = licenseCategory;
        this.equipmentList = new ArrayList<>();
        this.temporaryNote = "Временная метка";
        totalMotorcyclists++;
    }

    public static int getTotalMotorcyclists() {
        return totalMotorcyclists;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public String getLicenseCategory() { return licenseCategory; }
    public void setLicenseCategory(String licenseCategory) { this.licenseCategory = licenseCategory; }
    public String getTemporaryNote() { return temporaryNote; }
    public void setTemporaryNote(String temporaryNote) { this.temporaryNote = temporaryNote; }
    public List<Equipment> getEquipmentList() { return new ArrayList<>(equipmentList); }

    public void addEquipment(Equipment equipment) {
        if (equipment != null) {
            equipmentList.add(equipment);
        }
    }

    public boolean removeEquipment(String name) {
        return equipmentList.removeIf(e -> e.getName().equalsIgnoreCase(name));
    }

    public double calculateTotalCost() {
        return equipmentList.stream().mapToDouble(Equipment::getPrice).sum();
    }

    public double calculateTotalWeight() {
        return equipmentList.stream().mapToDouble(Equipment::getWeight).sum();
    }

    public void sortByWeight() {
        equipmentList.sort(Comparator.comparingDouble(Equipment::getWeight));
    }

    public List<Equipment> findEquipmentByPriceRange(double minPrice, double maxPrice) {
        return equipmentList.stream()
                .filter(e -> e.getPrice() >= minPrice && e.getPrice() <= maxPrice)
                .toList();
    }

    public List<Equipment> findEquipmentByType(String type) {
        return equipmentList.stream()
                .filter(e -> e.getType().equalsIgnoreCase(type))
                .toList();
    }

    public void printEquipment() {
        if (equipmentList.isEmpty()) {
            System.out.println("  Экипировка отсутствует");
            return;
        }

        System.out.printf("  %-12s | %-20s | %-15s | %-10s | %-10s%n",
                "Тип", "Название", "Бренд", "Вес (кг)", "Цена (руб)");
        System.out.println("  " + "-".repeat(75));

        for (Equipment e : equipmentList) {
            System.out.printf("  %-12s | %-20s | %-15s | %-10.2f | %-10.2f%n",
                    e.getType(), e.getName(), e.getBrand(), e.getWeight(), e.getPrice());
        }
    }

    @Override
    public String toString() {
        return String.format("Мотоциклист: %s, %d лет, категория: %s, предметов: %d, вес: %.2f кг, стоимость: %.2f руб.",
                name, age, licenseCategory, equipmentList.size(), calculateTotalWeight(), calculateTotalCost());
    }
}