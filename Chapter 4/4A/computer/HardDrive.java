package computer;

import java.util.Objects;

public class HardDrive {
    private String model;
    private long capacity; // в гигабайтах
    private double usedSpace; // в гигабайтах
    private boolean hasViruses;

    public HardDrive(String model, long capacity) {
        this.model = model;
        this.capacity = capacity;
        this.usedSpace = 0;
        this.hasViruses = false;
    }

    public HardDrive(String model, long capacity, double usedSpace) {
        this(model, capacity);
        this.usedSpace = Math.min(usedSpace, capacity);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public long getCapacity() {
        return capacity;
    }

    public void setCapacity(long capacity) {
        if (capacity > 0) {
            this.capacity = capacity;
            if (usedSpace > capacity) {
                usedSpace = capacity;
            }
        }
    }

    public double getUsedSpace() {
        return usedSpace;
    }

    public void setUsedSpace(double usedSpace) {
        this.usedSpace = Math.min(usedSpace, capacity);
    }

    public boolean hasViruses() {
        return hasViruses;
    }

    public void setHasViruses(boolean hasViruses) {
        this.hasViruses = hasViruses;
    }

    public double getFreeSpace() {
        return capacity - usedSpace;
    }

    public void writeData(double size) {
        if (size <= getFreeSpace()) {
            usedSpace += size;
        } else {
            throw new IllegalStateException("Недостаточно свободного места на винчестере");
        }
    }

    public void deleteData(double size) {
        usedSpace = Math.max(0, usedSpace - size);
    }

    public void scanForViruses() {
        if (hasViruses) {
            System.out.println("  Обнаружены вирусы на винчестере! Проведите очистку.");
        } else {
            System.out.println("  Вирусы на винчестере не обнаружены.");
        }
    }

    public void cleanViruses() {
        if (hasViruses) {
            hasViruses = false;
            System.out.println("  Вирусы на винчестере удалены.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HardDrive hardDrive = (HardDrive) o;
        return capacity == hardDrive.capacity &&
                Double.compare(usedSpace, hardDrive.usedSpace) == 0 &&
                hasViruses == hardDrive.hasViruses &&
                Objects.equals(model, hardDrive.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, capacity, usedSpace, hasViruses);
    }

    @Override
    public String toString() {
        return String.format("Винчестер: %s | Объем: %d GB | Занято: %.1f GB | Свободно: %.1f GB%s",
                model, capacity, usedSpace, getFreeSpace(),
                hasViruses ? " | ⚠ ЗАРАЖЕН" : "");
    }
}