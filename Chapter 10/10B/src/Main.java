//Выполнить задания из варианта B гл. 4, сохраняя объекты приложения в од- 
//ном или нескольких файлах с применением механизма сериализации. Объекты 
//могут содержать поля, помеченные как static, а также transient. Для изменения 
//информации и извлечения информации в файле создать специальный класс- 
//коннектор с необходимыми для выполнения этих задач методами.

//Создать консольное приложение, удовлетворяющее следующим требованиям: 
//• Использовать возможности ООП: классы, наследование, полиморфизм, ин- 
//капсуляция. 
//• Каждый класс должен иметь отражающее смысл название и инфор 
//мативный состав.

//7. Мотоциклист. Определить иерархию амуниции. Экипировать мотоцикли- 
//ста. Подсчитать стоимость. Провести сортировку амуниции на основе веса. 
//Найти элементы амуниции, соответствующие заданному диапазону пара- 
//метров цены. 

//ТОРЯШИЕВ ЖАРГАЛ Б763-2А

import connector.FileConnector;
import model.equipment.Equipment;
import model.rider.Motorcyclist;
import service.EquipmentService;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String DATA_FILE = "motorcyclist.ser";
    private static Motorcyclist motorcyclist;

    public static void main(String[] args) {
        System.out.println("МОТОЦИКЛИСТ ЭКИПИРОВКА");

        loadData();

        boolean running = true;
        while (running) {
            printMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    showInfo();
                    break;
                case "2":
                    showEquipment();
                    break;
                case "3":
                    calculateCost();
                    break;
                case "4":
                    sortByWeight();
                    break;
                case "5":
                    findByPriceRange();
                    break;
                case "6":
                    addDefaultEquipment();
                    break;
                case "7":
                    saveData();
                    break;
                case "8":
                    saveAndExit();
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор!");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n" + "-".repeat(40));
        System.out.println("1. Информация о мотоциклисте");
        System.out.println("2. Показать экипировку");
        System.out.println("3. Подсчитать стоимость");
        System.out.println("4. Сортировать по весу");
        System.out.println("5. Найти по диапазону цен");
        System.out.println("6. Добавить экипировку");
        System.out.println("7. Сохранить");
        System.out.println("8. Выход");
        System.out.print("Выберите: ");
    }

    private static void loadData() {
        try {
            motorcyclist = FileConnector.loadMotorcyclist(DATA_FILE);
            if (motorcyclist == null) {
                createNewMotorcyclist();
            } else {
                System.out.println("Загружен: " + motorcyclist);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Ошибка загрузки: " + e.getMessage());
            createNewMotorcyclist();
        }
    }

    private static void createNewMotorcyclist() {
        System.out.println("\nСоздание нового мотоциклиста:");
        System.out.print("Имя: ");
        String name = scanner.nextLine();
        System.out.print("Возраст: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.print("Категория прав (A/A1/A2): ");
        String category = scanner.nextLine();

        motorcyclist = new Motorcyclist(name, age, category);
        System.out.println("Мотоциклист создан!");
    }

    private static void showInfo() {
        System.out.println("\n ИНФОРМАЦИЯ ");
        System.out.println(motorcyclist);
    }

    private static void showEquipment() {
        System.out.println("\n ЭКИПИРОВКА ");
        motorcyclist.printEquipment();
    }

    private static void calculateCost() {
        System.out.println("\n СТОИМОСТЬ ");
        System.out.printf("Общая стоимость: %.2f руб.%n", motorcyclist.calculateTotalCost());
        System.out.printf("Общий вес: %.2f кг%n", motorcyclist.calculateTotalWeight());
    }

    private static void sortByWeight() {
        System.out.println("\n СОРТИРОВКА ПО ВЕСУ ");
        motorcyclist.sortByWeight();
        motorcyclist.printEquipment();
    }

    private static void findByPriceRange() {
        System.out.println("\n ПОИСК ПО ЦЕНЕ ");
        System.out.print("Мин. цена: ");
        double min = Double.parseDouble(scanner.nextLine());
        System.out.print("Макс. цена: ");
        double max = Double.parseDouble(scanner.nextLine());

        List<Equipment> found = motorcyclist.findEquipmentByPriceRange(min, max);

        if (found.isEmpty()) {
            System.out.println("Не найдено");
        } else {
            System.out.printf("Найдено %d предметов:%n", found.size());
            for (Equipment e : found) {
                System.out.printf("  %s - %.2f руб.%n", e.getName(), e.getPrice());
            }
        }
    }

    private static void addDefaultEquipment() {
        System.out.println("\n ДОБАВЛЕНИЕ ЭКИПИРОВКИ ");
        EquipmentService.addDefaultEquipment(motorcyclist);
        System.out.println("Экипировка добавлена!");
        motorcyclist.printEquipment();
    }

    private static void saveData() {
        try {
            FileConnector.saveMotorcyclist(DATA_FILE, motorcyclist);
        } catch (IOException e) {
            System.err.println("Ошибка сохранения: " + e.getMessage());
        }
    }

    private static void saveAndExit() {
        saveData();
        System.out.println("До свидания!");
    }
}
