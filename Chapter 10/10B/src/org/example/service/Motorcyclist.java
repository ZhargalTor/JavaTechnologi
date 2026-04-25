package org.example.service;

import org.example.model.Equipment;

import java.util.*;
import java.util.stream.Collectors;

public class Motorcyclist {

    private List<Equipment> equipmentList = new ArrayList<>();

    public void addEquipment(Equipment eq) {
        equipmentList.add(eq);
    }

    public double getTotalPrice() {
        return equipmentList.stream()
                .mapToDouble(Equipment::getPrice)
                .sum();
    }

    public void sortByWeight() {
        equipmentList.sort(Comparator.comparingDouble(Equipment::getWeight));
    }

    public List<Equipment> findByPriceRange(double min, double max) {
        return equipmentList.stream()
                .filter(e -> e.getPrice() >= min && e.getPrice() <= max)
                .collect(Collectors.toList());
    }

    public List<Equipment> getAll() {
        return equipmentList;
    }
}