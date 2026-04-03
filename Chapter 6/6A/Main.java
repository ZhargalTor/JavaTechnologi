/*
7. Средство передвижения. Возможности: получить или изменить различную
        информацию о средстве передвижения: регистрационный номер, марка, мо-
        дель, VIN-номер, владелец, тип движущей силы; заправить\отремонтиро-
        вать\обслужить; пройти техосмотр. Добавить дополнительные возможности
        для автомобиля, велосипеда, самоката, мотоцикла, квадроцикла.
*/




import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Vehicle> vehicles = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        addSampleVehicles();

        boolean running = true;

        while (running) {
            System.out.println("УПРАВЛЕНИЕ СРЕДСТВАМИ ПЕРЕДВИЖЕНИЯ");
            System.out.println("1. Показать все средства передвижения");
            System.out.println("2. Добавить новое средство передвижения");
            System.out.println("3. Выбрать средство для управления");
            System.out.println("4. Выйти");
            System.out.print("Выберите опцию: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    showAllVehicles();
                    break;
                case "2":
                    addNewVehicle();
                    break;
                case "3":
                    manageVehicle();
                    break;
                case "4":
                    running = false;
                    System.out.println("До свидания!");
                    break;
                default:
                    System.out.println("Неверный выбор!");
            }
        }

        scanner.close();
    }

    private static void addSampleVehicles() {
        vehicles.add(new Car("A123BC", "Toyota", "Camry", "JTDBE30K000000001",
                "Иван Петров", "Бензин", 4, true));
        vehicles.add(new Bicycle("B456CD", "Giant", "Escape 3", "GIANT001",
                "Мария Сидорова", "Мускульная", 21, true));
        vehicles.add(new Scooter("C789EF", "Honda", "Dio", "HONDA001",
                "Алексей Иванов", "Бензин", 49, true));
        vehicles.add(new Motorcycle("D012GH", "Yamaha", "R6", "YAMAHA001",
                "Дмитрий Козлов", "Бензин", 600, false));
        vehicles.add(new QuadBike("E345IJ", "CFMoto", "CForce 600", "CFMOTO001",
                "Сергей Новиков", "Бензин", 600, true));
    }

    private static void showAllVehicles() {
        if (vehicles.isEmpty()) {
            System.out.println("Нет зарегистрированных средств передвижения");
            return;
        }

        for (int i = 0; i < vehicles.size(); i++) {
            System.out.println((i + 1) + ". " + getVehicleType(vehicles.get(i)) +
                    " | " + vehicles.get(i).getBrand() + " " +
                    vehicles.get(i).getModel() + " | Владелец: " +
                    vehicles.get(i).getOwner());
        }
    }

    private static String getVehicleType(Vehicle v) {
        if (v instanceof Car) return "Автомобиль";
        if (v instanceof Bicycle) return "Велосипед";
        if (v instanceof Scooter) return "Самокат";
        if (v instanceof Motorcycle) return "Мотоцикл";
        if (v instanceof QuadBike) return "Квадроцикл";
        return "Неизвестно";
    }

    private static void addNewVehicle() {
        System.out.println("\n ДОБАВЛЕНИЕ НОВОГО СРЕДСТВА ");
        System.out.println("1. Автомобиль");
        System.out.println("2. Велосипед");
        System.out.println("3. Самокат");
        System.out.println("4. Мотоцикл");
        System.out.println("5. Квадроцикл");
        System.out.print("Выберите тип: ");

        String type = scanner.nextLine();

        System.out.print("Регистрационный номер: ");
        String regNumber = scanner.nextLine();
        System.out.print("Марка: ");
        String brand = scanner.nextLine();
        System.out.print("Модель: ");
        String model = scanner.nextLine();
        System.out.print("VIN номер: ");
        String vin = scanner.nextLine();
        System.out.print("Владелец: ");
        String owner = scanner.nextLine();
        System.out.print("Тип двигателя/привода: ");
        String powerType = scanner.nextLine();

        switch (type) {
            case "1":
                System.out.print("Количество дверей: ");
                int doors = Integer.parseInt(scanner.nextLine());
                System.out.print("Наличие кондиционера (true/false): ");
                boolean ac = Boolean.parseBoolean(scanner.nextLine());
                vehicles.add(new Car(regNumber, brand, model, vin, owner, powerType, doors, ac));
                break;
            case "2":
                System.out.print("Количество скоростей: ");
                int gears = Integer.parseInt(scanner.nextLine());
                System.out.print("Наличие фар (true/false): ");
                boolean lights = Boolean.parseBoolean(scanner.nextLine());
                vehicles.add(new Bicycle(regNumber, brand, model, vin, owner, powerType, gears, lights));
                break;
            case "3":
                System.out.print("Объём двигателя (см³): ");
                int engineVol = Integer.parseInt(scanner.nextLine());
                System.out.print("Наличие подножки (true/false): ");
                boolean kickstand = Boolean.parseBoolean(scanner.nextLine());
                vehicles.add(new Scooter(regNumber, brand, model, vin, owner, powerType, engineVol, kickstand));
                break;
            case "4":
                System.out.print("Объём двигателя (см³): ");
                int engineVolM = Integer.parseInt(scanner.nextLine());
                System.out.print("Наличие коляски (true/false): ");
                boolean sidecar = Boolean.parseBoolean(scanner.nextLine());
                vehicles.add(new Motorcycle(regNumber, brand, model, vin, owner, powerType, engineVolM, sidecar));
                break;
            case "5":
                System.out.print("Объём двигателя (см³): ");
                int engineVolQ = Integer.parseInt(scanner.nextLine());
                System.out.print("Наличие лебёдки (true/false): ");
                boolean winch = Boolean.parseBoolean(scanner.nextLine());
                vehicles.add(new QuadBike(regNumber, brand, model, vin, owner, powerType, engineVolQ, winch));
                break;
            default:
                System.out.println("Неверный тип!");
        }

        System.out.println("Средство передвижения добавлено!");
    }

    private static void manageVehicle() {
        if (vehicles.isEmpty()) {
            System.out.println("Нет зарегистрированных средств передвижения");
            return;
        }

        showAllVehicles();
        System.out.print("Выберите номер средства: ");
        int index = Integer.parseInt(scanner.nextLine()) - 1;

        if (index < 0 || index >= vehicles.size()) {
            System.out.println("Неверный выбор!");
            return;
        }

        Vehicle v = vehicles.get(index);

        boolean managing = true;
        while (managing) {
            System.out.println("\n УПРАВЛЕНИЕ: " + v.getBrand() + " " + v.getModel());
            System.out.println("1. Показать информацию");
            System.out.println("2. Заправить");
            System.out.println("3. Отремонтировать");
            System.out.println("4. Обслужить");
            System.out.println("5. Пройти техосмотр");
            System.out.println("6. Изменить владельца");
            System.out.println("7. Изменить рег. номер");
            System.out.println("8. Вернуться в главное меню");
            System.out.print("Выберите действие: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    v.displayInfo();
                    break;
                case "2":
                    v.refuel();
                    break;
                case "3":
                    v.repair();
                    break;
                case "4":
                    v.service();
                    break;
                case "5":
                    v.technicalInspection();
                    break;
                case "6":
                    System.out.print("Введите нового владельца: ");
                    String newOwner = scanner.nextLine();
                    v.setOwner(newOwner);
                    System.out.println("Владелец изменён!");
                    break;
                case "7":
                    System.out.print("Введите новый рег. номер: ");
                    String newReg = scanner.nextLine();
                    v.setRegistrationNumber(newReg);
                    System.out.println("Рег. номер изменён!");
                    break;
                case "8":
                    managing = false;
                    break;
                default:
                    System.out.println("Неверный выбор!");
            }
        }
    }
}
