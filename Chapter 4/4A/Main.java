package computer;

public class Main {
    public static void main(String[] args) {

        System.out.println("СОЗДАНИЕ КОМПЬЮТЕРА");

        HardDrive hdd = new HardDrive("Samsung 970 EVO", 1000, 350.5);
        Drive dvdDrive = new Drive("DVD-RW", "LG GH24NSD5");
        RAM ram = new RAM("DDR4", 16, 3200, 4.5);
        Processor cpu = new Processor("AMD Ryzen 7 5800X", 8, 3.8);

        Computer computer = new Computer("DNS", "ARDOR GAMING", hdd, dvdDrive, ram, cpu);

        computer.showSystemInfo();

        System.out.println("ДЕМОНСТРАЦИЯ РАБОТЫ КОМПЬЮТЕРА");

        System.out.println("\n1. ПРОВЕРКА НА ВИРУСЫ (компьютер выключен):");
        computer.scanForViruses();

        System.out.println("\n2. ВКЛЮЧЕНИЕ КОМПЬЮТЕРА:");
        computer.turnOn();

        System.out.println("\n3. ПРОВЕРКА НА ВИРУСЫ:");
        computer.scanForViruses();

        System.out.println("\n4. ИМИТАЦИЯ ЗАРАЖЕНИЯ ВИРУСОМ:");
        hdd.setHasViruses(true);
        System.out.println("  Винчестер заражен вирусом!");

        System.out.println("\n5. ПОВТОРНАЯ ПРОВЕРКА НА ВИРУСЫ:");
        computer.scanForViruses();

        System.out.println("\n6. ОЧИСТКА ОТ ВИРУСОВ:");
        computer.cleanViruses();

        System.out.println("\n7. ПРОВЕРКА ПОСЛЕ ОЧИСТКИ:");
        computer.scanForViruses();

        System.out.println("\n8. ИНФОРМАЦИЯ О ВИНЧЕСТЕРЕ:");
        computer.printHardDriveCapacity();

        System.out.println("\n9. РАБОТА С ДИСКОВОДОМ:");
        dvdDrive.insertDisc();
        dvdDrive.readDisc();
        dvdDrive.ejectDisc();

        System.out.println("\n10. РАБОТА С ОПЕРАТИВНОЙ ПАМЯТЬЮ:");
        System.out.printf("  Свободно ОЗУ: %.1f GB%n", ram.getFreeMemory());
        ram.allocateMemory(2);
        System.out.printf("  После выделения 2 GB: %.1f GB свободно%n", ram.getFreeMemory());
        ram.freeMemory(1);
        System.out.printf("  После освобождения 1 GB: %.1f GB свободно%n", ram.getFreeMemory());

        System.out.println("\n11. РАБОТА С ПРОЦЕССОРОМ:");
        cpu.executeTask("Загрузка ОС");
        cpu.executeTask("Запуск браузера");

        System.out.println("\n12. ВЫКЛЮЧЕНИЕ КОМПЬЮТЕРА:");
        computer.turnOff();

        System.out.println("\n13. ОПЕРАЦИИ ПОСЛЕ ВЫКЛЮЧЕНИЯ:");
        computer.scanForViruses();
        cpu.executeTask("Запуск программы");

        System.out.println("ФИНАЛЬНАЯ ИНФОРМАЦИЯ О КОМПЬЮТЕРЕ:");
        computer.showSystemInfo();

        System.out.println("ДЕМОНСТРАЦИЯ equals(), hashCode(), toString():");

        Computer computer2 = new Computer("ASUS", "ROG Strix G15");
        Computer computer3 = new Computer("ASUS", "ROG Strix G15",
                new HardDrive("Samsung 970 EVO", 1000, 350.5),
                new Drive("DVD-RW", "LG GH24NSD5"),
                new RAM("DDR4", 16, 3200, 4.5),
                new Processor("AMD Ryzen 7 5800X", 8, 3.8));

        System.out.println("computer.toString(): " + computer);
        System.out.println("computer2.toString(): " + computer2);
        System.out.println("computer3.toString(): " + computer3);
        System.out.println("\ncomputer.equals(computer2): " + computer.equals(computer2));
        System.out.println("computer.equals(computer3): " + computer.equals(computer3));
        System.out.println("computer.hashCode(): " + computer.hashCode());
        System.out.println("computer3.hashCode(): " + computer3.hashCode());
        System.out.println("computer.hashCode() == computer3.hashCode(): " +
                (computer.hashCode() == computer3.hashCode()));
    }
}