package computer;

import java.util.Objects;

public class Computer {
    private String brand;
    private String model;
    private HardDrive hardDrive;
    private Drive drive;
    private RAM ram;
    private Processor processor;
    private boolean isOn;
    private boolean isInfected;

    public Computer(String brand, String model,
                    HardDrive hardDrive, Drive drive,
                    RAM ram, Processor processor) {
        this.brand = brand;
        this.model = model;
        this.hardDrive = hardDrive;
        this.drive = drive;
        this.ram = ram;
        this.processor = processor;
        this.isOn = false;
        this.isInfected = false;
    }

    public Computer(String brand, String model) {
        this(brand, model,
                new HardDrive("Default HDD", 500),
                new Drive("DVD", "Default DVD-RW"),
                new RAM("DDR4", 8, 2400),
                new Processor("Intel Core i5", 4, 2.5));
    }

    public void turnOn() {
        if (!isOn) {
            isOn = true;
            processor.start();
            System.out.println("Компьютер включен");
        } else {
            System.out.println("Компьютер уже включен");
        }
    }

    public void turnOff() {
        if (isOn) {
            isOn = false;
            processor.stop();
            System.out.println("Компьютер выключен");
        } else {
            System.out.println("Компьютер уже выключен");
        }
    }

    public void scanForViruses() {
        if (!isOn) {
            System.out.println("Невозможно проверить: компьютер выключен");
            return;
        }

        System.out.println("Начинается проверка на вирусы...");
        System.out.println("Проверка системных файлов...");

        if (hardDrive.hasViruses()) {
            isInfected = true;
            System.out.println("⚠ ВНИМАНИЕ: Обнаружены вирусы на винчестере!");
            hardDrive.scanForViruses();
        } else {
            System.out.println("Вирусы на винчестере не обнаружены.");
        }

        if (isInfected) {
            System.out.println("Компьютер заражен вирусами!");
        } else {
            System.out.println("Компьютер чист. Вирусы не обнаружены.");
        }
    }

    public void cleanViruses() {
        if (!isOn) {
            System.out.println("Невозможно очистить: компьютер выключен");
            return;
        }

        if (isInfected || hardDrive.hasViruses()) {
            System.out.println("Запуск антивирусной программы...");
            hardDrive.cleanViruses();
            isInfected = false;
            System.out.println("Очистка завершена. Вирусы удалены.");
        } else {
            System.out.println("Вирусы не обнаружены. Очистка не требуется.");
        }
    }

    public void printHardDriveCapacity() {
        System.out.printf("Размер винчестера: %d GB%n", hardDrive.getCapacity());
        System.out.printf("Свободное место: %.1f GB%n", hardDrive.getFreeSpace());
        System.out.printf("Занятое место: %.1f GB%n", hardDrive.getUsedSpace());
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public HardDrive getHardDrive() {
        return hardDrive;
    }

    public void setHardDrive(HardDrive hardDrive) {
        this.hardDrive = hardDrive;
    }

    public Drive getDrive() {
        return drive;
    }

    public void setDrive(Drive drive) {
        this.drive = drive;
    }

    public RAM getRam() {
        return ram;
    }

    public void setRam(RAM ram) {
        this.ram = ram;
    }

    public Processor getProcessor() {
        return processor;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public boolean isOn() {
        return isOn;
    }

    public boolean isInfected() {
        return isInfected;
    }

    public void showSystemInfo() {
        System.out.printf("КОМПЬЮТЕР: %s %s%n", brand, model);
        System.out.println(processor);
        System.out.println(ram);
        System.out.println(hardDrive);
        System.out.println(drive);
        System.out.printf("Состояние: %s%n", isOn ? "Включен" : "Выключен");
        System.out.printf("Заражение: %s%n", isInfected ? "Есть вирусы" : "Чист");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Computer computer = (Computer) o;
        return isOn == computer.isOn &&
                isInfected == computer.isInfected &&
                Objects.equals(brand, computer.brand) &&
                Objects.equals(model, computer.model) &&
                Objects.equals(hardDrive, computer.hardDrive) &&
                Objects.equals(drive, computer.drive) &&
                Objects.equals(ram, computer.ram) &&
                Objects.equals(processor, computer.processor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, hardDrive, drive, ram, processor, isOn, isInfected);
    }

    @Override
    public String toString() {
        return String.format("Computer[%s %s, Состояние: %s, Вирусы: %s]",
                brand, model, isOn ? "ON" : "OFF", isInfected ? "Да" : "Нет");
    }
}