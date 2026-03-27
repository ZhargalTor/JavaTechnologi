package computer;

import java.util.Objects;

public class RAM {
    private String type; // DDR3, DDR4, DDR5
    private int size; // в гигабайтах
    private int frequency; // в мегагерцах
    private double usedMemory; // в гигабайтах

    public RAM(String type, int size, int frequency) {
        this.type = type;
        this.size = size;
        this.frequency = frequency;
        this.usedMemory = 0;
    }

    public RAM(String type, int size, int frequency, double usedMemory) {
        this(type, size, frequency);
        this.usedMemory = Math.min(usedMemory, size);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        if (size > 0) {
            this.size = size;
            if (usedMemory > size) {
                usedMemory = size;
            }
        }
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public double getUsedMemory() {
        return usedMemory;
    }

    public void setUsedMemory(double usedMemory) {
        this.usedMemory = Math.min(usedMemory, size);
    }

    public double getFreeMemory() {
        return size - usedMemory;
    }

    public void allocateMemory(double size) {
        if (size <= getFreeMemory()) {
            usedMemory += size;
        } else {
            throw new IllegalStateException("Недостаточно оперативной памяти");
        }
    }

    public void freeMemory(double size) {
        usedMemory = Math.max(0, usedMemory - size);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RAM ram = (RAM) o;
        return size == ram.size &&
                frequency == ram.frequency &&
                Double.compare(usedMemory, ram.usedMemory) == 0 &&
                Objects.equals(type, ram.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, size, frequency, usedMemory);
    }

    @Override
    public String toString() {
        return String.format("ОЗУ: %s %d GB | Частота: %d MHz | Занято: %.1f GB | Свободно: %.1f GB",
                type, size, frequency, usedMemory, getFreeMemory());
    }
}