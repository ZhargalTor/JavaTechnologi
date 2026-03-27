package model.rider;

import model.equipment.Equipment;
import java.io.Serializable;
import java.util.*;

public class Motorcyclist implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private int age;
    private String licenseCategory;
    private List<Equipment> equipmentList;

    public Motorcyclist(String name, int age, String licenseCategory) {
        this.name = name;
        this.age = age;
        this.licenseCategory = licenseCategory;
        this.equipmentList = new ArrayList<>();
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public String getLicenseCategory() { return licenseCategory; }
    public void setLicenseCategory(String licenseCategory) { this.licenseCategory = licenseCategory; }
    public List<Equipment> getEquipmentList() { return new ArrayList<>(equipmentList); }

    public void addEquipment(Equipment equipment) {
        if (equipment != null) {
            equipmentList.add(equipment);
            System.out.println("Добавлено: " + equipment.getName());
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
        System.out.println("Экипировка отсортирована по весу");
    }

    public void sortByPrice() {
        equipmentList.sort(Comparator.comparingDouble(Equipment::getPrice));
        System.out.println("Экипировка отсортирована по цене");
    }

    public void sortByName() {
        equipmentList.sort(Comparator.comparing(Equipment::getName));
        System.out.println("Экипировка отсортирована по названию");
    }

    public List<Equipment> findEquipmentByPriceRange(double minPrice, double maxPrice) {
        return equipmentList.stream()
                .filter(e -> e.getPrice() >= minPrice && e.getPrice() <= maxPrice)
                .toList();
    }

    public List<Equipment> findEquipmentByWeightRange(double minWeight, double maxWeight) {
        return equipmentList.stream()
                .filter(e -> e.getWeight() >= minWeight && e.getWeight() <= maxWeight)
                .toList();
    }

    public List<Equipment> findEquipmentByType(String type) {
        return equipmentList.stream()
                .filter(e -> e.getType().equalsIgnoreCase(type))
                .toList();
    }

    public void printEquipment() {
        if (equipmentList.isEmpty()) {
            System.out.println("Экипировка отсутствует");
            return;
        }

        System.out.println("\n" + "=".repeat(120));
        System.out.printf("%-12s | %-20s | %-15s | %-15s | %-12s | %-12s | %s%n",
                "Тип", "Название", "Бренд", "Вес", "Цена", "Материал", "Дополнительно");
        System.out.println("=".repeat(120));

        for (Equipment e : equipmentList) {
            System.out.println(e);
        }
        System.out.println("=".repeat(120));
        System.out.printf("ИТОГО: Вес: %.2f кг | Стоимость: %.2f руб.%n",
                calculateTotalWeight(), calculateTotalCost());
    }

    @Override
    public String toString() {
        return String.format("Мотоциклист: %s, %d лет, категория: %s, экипировка: %d предметов, вес: %.2f кг, стоимость: %.2f руб.",
                name, age, licenseCategory, equipmentList.size(), calculateTotalWeight(), calculateTotalCost());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Motorcyclist that = (Motorcyclist) o;
        return age == that.age &&
                Objects.equals(name, that.name) &&
                Objects.equals(licenseCategory, that.licenseCategory) &&
                Objects.equals(equipmentList, that.equipmentList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, licenseCategory, equipmentList);
    }
}