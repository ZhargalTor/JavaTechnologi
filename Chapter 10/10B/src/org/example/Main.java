package org.example;

import org.example.io.FileConnector;
import org.example.model.*;
import org.example.service.Motorcyclist;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Motorcyclist m = new Motorcyclist();

        // экипировка
        m.addEquipment(new Helmet("Shoei", 500, 1.5));
        m.addEquipment(new Jacket("Alpinestars", 300, 2.0));
        m.addEquipment(new Boots("TCX", 200, 1.8));

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Показать всё");
            System.out.println("2. Сумма");
            System.out.println("3. Сортировка по весу");
            System.out.println("4. Поиск по цене");
            System.out.println("5. Сохранить");
            System.out.println("6. Загрузить");
            System.out.println("0. Выход");

            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> m.getAll().forEach(System.out::println);

                case 2 -> System.out.println("Сумма: " + m.getTotalPrice());

                case 3 -> {
                    m.sortByWeight();
                    System.out.println("Отсортировано");
                }

                case 4 -> {
                    System.out.print("Мин: ");
                    double min = sc.nextDouble();
                    System.out.print("Макс: ");
                    double max = sc.nextDouble();

                    List<?> result = m.findByPriceRange(min, max);
                    result.forEach(System.out::println);
                }

                case 5 -> FileConnector.save("data.ser", m.getAll());

                case 6 -> {
                    Object data = FileConnector.load("data.ser");
                    if (data instanceof List<?> list) {
                        list.forEach(System.out::println);
                    }
                }

                case 0 -> System.exit(0);
            }
        }
    }
}