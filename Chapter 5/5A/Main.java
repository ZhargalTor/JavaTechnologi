/*7. Создать класс Европа с внутренним классом, с помощью объектов которо-
        го можно хранить информацию об истории изменения территориального
        деления на государства.*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Europe europe = new Europe("Европа");

        europe.addChange("Германия", 1871, "Объединение германских государств в Германскую империю");
        europe.addChange("Австро-Венгрия", 1918, "Распад Австро-Венгерской империи");
        europe.addChange("Россия", 1917, "Распад Российской империи, образование РСФСР");
        europe.addChange("Польша", 1918, "Восстановление независимости Польши");
        europe.addChange("СССР", 1922, "Образование Союза Советских Социалистических Республик");
        europe.addChange("Германия", 1949, "Разделение Германии на ФРГ и ГДР");
        europe.addChange("Германия", 1990, "Объединение Германии");
        europe.addChange("СССР", 1991, "Распад СССР, образование 15 независимых государств");
        europe.addChange("Чехословакия", 1993, "Разделение на Чехию и Словакию");
        europe.addChange("Югославия", 1992, "Начало распада Югославии");
        europe.addChange("Косово", 2008, "Провозглашение независимости");

        boolean running = true;

        while (running) {
            System.out.println("ИСТОРИЯ ТЕРРИТОРИАЛЬНОГО ДЕЛЕНИЯ ЕВРОПЫ");
            System.out.println("1. Показать всю историю");
            System.out.println("2. Добавить новое изменение");
            System.out.println("3. Выйти");
            System.out.print("Выберите опцию: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    europe.showHistory();
                    break;
                case "2":
                    System.out.print("Введите название страны: ");
                    String newCountry = scanner.nextLine();
                    System.out.print("Введите год: ");
                    int newYear = Integer.parseInt(scanner.nextLine());
                    System.out.print("Введите описание события: ");
                    String newEvent = scanner.nextLine();
                    europe.addChange(newCountry, newYear, newEvent);
                    System.out.println("Изменение добавлено!");
                    break;
                case "3":
                    running = false;
                    System.out.println("До свидания!");
                    break;
                default:
                    System.out.println("Неверный выбор!");
            }
        }

        scanner.close();
    }
}