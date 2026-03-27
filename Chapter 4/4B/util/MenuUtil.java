package util;

import model.equipment.Equipment;
import model.rider.Motorcyclist;
import service.EquipmentService;
import service.FileService;
import java.util.List;
import java.util.Scanner;

public class MenuUtil {
    private static final Scanner scanner = new Scanner(System.in);
    private static Motorcyclist motorcyclist;

    public static void start() {
        System.out.println("=".repeat(60));
        System.out.println("   МОТОЦИКЛИСТ - СИСТЕМА УПРАВЛЕНИЯ ЭКИПИРОВКОЙ");
        System.out.println("=".repeat(60));

        motorcyclist = FileService.loadFromFile();

        if (motorcyclist == null) {
            createNewMotorcyclist();
        } else {
            System.out.println("Загруженные данные:");
            System.out.println(motorcyclist);
            System.out.print("Продолжить с этими данными? (y/n): ");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("n")) {
                createNewMotorcyclist();
            }
        }

        boolean running = true;
        while (running) {
            printMainMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    showEquipment();
                    break;
                case "2":
                    addEquipment();
                    break;
                case "3":
                    removeEquipment();
                    break;
                case "4":
                    calculateTotalCost();
                    break;
                case "5":
                    sortByWeight();
                    break;
                case "6":
                    findEquipmentByPriceRange();
                    break;
                case "7":
                    showStatistics();
                    break;
                case "8":
                    loadDefaultEquipment();
                    break;
                case "9":
                    saveAndExit();
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }

    private static void createNewMotorcyclist() {
        System.out.println("\n--- СОЗДАНИЕ НОВОГО МОТОЦИКЛИСТА ---");
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();

        System.out.print("Введите возраст: ");
        int age = Integer.parseInt(scanner.nextLine());

        System.out.print("Введите категорию прав (A, A1, A2): ");
        String category = scanner.nextLine();

        motorcyclist = new Motorcyclist(name, age, category);
        System.out.println("Мотоциклист создан успешно!");

        System.out.print("Добавить предустановленную экипировку? (y/n): ");
        if (scanner.nextLine().equalsIgnoreCase("y")) {
            EquipmentService.addDefaultEquipment(motorcyclist);
        }
    }

    private static void printMainMenu() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("ГЛАВНОЕ МЕНЮ:");
        System.out.println("=".repeat(50));
        System.out.println("1. Показать всю экипировку");
        System.out.println("2. Добавить экипировку");
        System.out.println("3. Удалить экипировку");
        System.out.println("4. Подсчитать общую стоимость");
        System.out.println("5. Сортировать экипировку по весу");
        System.out.println("6. Найти экипировку по диапазону цен");
        System.out.println("7. Показать статистику");
        System.out.println("8. Загрузить предустановленную экипировку");
        System.out.println("9. Сохранить и выйти");
        System.out.print("Выберите опцию: ");
    }

    private static void showEquipment() {
        System.out.println("\n--- ВСЯ ЭКИПИРОВКА ---");
        motorcyclist.printEquipment();
    }

    private static void addEquipment() {
        System.out.println("\n--- ДОБАВЛЕНИЕ ЭКИПИРОВКИ ---");
        System.out.println("Типы экипировки: Шлем, Куртка, Перчатки, Штаны, Ботинки, Защита");
        System.out.print("Выберите тип: ");
        String type = scanner.nextLine();

        System.out.print("Название: ");
        String name = scanner.nextLine();

        System.out.print("Бренд: ");
        String brand = scanner.nextLine();

        System.out.print("Вес (кг): ");
        double weight = Double.parseDouble(scanner.nextLine());

        System.out.print("Цена (руб): ");
        double price = Double.parseDouble(scanner.nextLine());

        System.out.print("Материал: ");
        String material = scanner.nextLine();

        System.out.print("Цвет: ");
        String color = scanner.nextLine();

        System.out.println("Функция добавления в разработке. Используйте загрузку предустановленной экипировки.");
    }

    private static void removeEquipment() {
        System.out.println("\n--- УДАЛЕНИЕ ЭКИПИРОВКИ ---");
        motorcyclist.printEquipment();
        System.out.print("Введите название экипировки для удаления: ");
        String name = scanner.nextLine();

        if (motorcyclist.removeEquipment(name)) {
            System.out.println("Экипировка удалена успешно!");
        } else {
            System.out.println("Экипировка с таким названием не найдена.");
        }
    }

    private static void calculateTotalCost() {
        System.out.println("\n--- ОБЩАЯ СТОИМОСТЬ ---");
        double totalCost = motorcyclist.calculateTotalCost();
        double totalWeight = motorcyclist.calculateTotalWeight();
        System.out.printf("Общая стоимость экипировки: %.2f руб.%n", totalCost);
        System.out.printf("Общий вес экипировки: %.2f кг%n", totalWeight);
    }

    private static void sortByWeight() {
        System.out.println("\n--- СОРТИРОВКА ПО ВЕСУ ---");
        motorcyclist.sortByWeight();
        motorcyclist.printEquipment();
    }

    private static void findEquipmentByPriceRange() {
        System.out.println("\n--- ПОИСК ПО ДИАПАЗОНУ ЦЕН ---");
        System.out.print("Введите минимальную цену: ");
        double minPrice = Double.parseDouble(scanner.nextLine());
        System.out.print("Введите максимальную цену: ");
        double maxPrice = Double.parseDouble(scanner.nextLine());

        List<Equipment> found = motorcyclist.findEquipmentByPriceRange(minPrice, maxPrice);

        if (found.isEmpty()) {
            System.out.println("Экипировка в заданном диапазоне цен не найдена.");
        } else {
            System.out.printf("\nНайдено %d предметов в диапазоне от %.2f до %.2f руб.:%n",
                    found.size(), minPrice, maxPrice);
            System.out.println("-".repeat(100));
            for (Equipment e : found) {
                System.out.printf("  %-12s | %-20s | %-15s | Цена: %.2f руб.%n",
                        e.getType(), e.getName(), e.getBrand(), e.getPrice());
            }
        }
    }

    private static void showStatistics() {
        System.out.println("\n--- СТАТИСТИКА ---");
        System.out.println(motorcyclist);

        List<Equipment> equipment = motorcyclist.getEquipmentList();
        if (!equipment.isEmpty()) {
            System.out.println("\nПо типам экипировки:");
            equipment.stream()
                    .collect(java.util.stream.Collectors.groupingBy(Equipment::getType, java.util.stream.Collectors.counting()))
                    .forEach((type, count) -> System.out.printf("  %s: %d шт.%n", type, count));

            System.out.println("\nПо брендам:");
            equipment.stream()
                    .collect(java.util.stream.Collectors.groupingBy(Equipment::getBrand, java.util.stream.Collectors.counting()))
                    .forEach((brand, count) -> System.out.printf("  %s: %d шт.%n", brand, count));
        }
    }

    private static void loadDefaultEquipment() {
        System.out.println("\n--- ЗАГРУЗКА ПРЕДУСТАНОВЛЕННОЙ ЭКИПИРОВКИ ---");
        System.out.print("Это действие добавит новую экипировку к существующей. Продолжить? (y/n): ");
        if (scanner.nextLine().equalsIgnoreCase("y")) {
            EquipmentService.addDefaultEquipment(motorcyclist);
            System.out.println("Предустановленная экипировка добавлена!");
        }
    }

    private static void saveAndExit() {
        System.out.println("\n--- СОХРАНЕНИЕ И ВЫХОД ---");
        FileService.saveToFile(motorcyclist);
        System.out.println("До свидания!");
    }
}