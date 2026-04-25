/*Задания к главе 9
        Вариант A
        В символьном файле находится информация об N числах с плавающей запятой
        с указанием локали каждого числа отдельно. Прочитать информацию из файла.
        Проверить на корректность, то есть являются ли числа числами. Преобразовать
        к числовым значениям и вычислить сумму и среднее значение прочитанных чисел.
        Создать собственный класс исключения. Предусмотреть обработку исклю-
        чений, возникающих при нехватке памяти, отсутствии самого файла по задан-
        ному адресу, отсутствии или некорректности требуемой записи в файле, недо-
        пустимом значении числа (выходящим за пределы максимально допустимых
        значений) и т.д.

ТОРЯШИЕВ ЖАРГАЛ Б763-2А*/



import java.io.*;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("ЧТЕНИЕ ЧИСЕЛ С ПЛАВАЮЩЕЙ ЗАПЯТОЙ ИЗ ФАЙЛА");
        System.out.println("Формат файла: число|локаль");
        System.out.println("Доступные локали: ru, us, de, fr");
        System.out.println("Пример: 1234,56|ru или 1234.56|us");

        System.out.print("Введите путь к файлу: ");
        String filename = scanner.nextLine();

        if (filename.isEmpty()) {
            filename = "numbers.txt";
        }

        try {
            List<Double> numbers = NumberReader.readNumbersFromFile(filename);

            System.out.println("РЕЗУЛЬТАТ ОБРАБОТКИ:");

            System.out.println("\nПрочитанные числа:");
            for (int i = 0; i < numbers.size(); i++) {
                System.out.printf("  %d. %.4f%n", i + 1, numbers.get(i));
            }

            double sum = NumberReader.calculateSum(numbers);
            double average = NumberReader.calculateAverage(numbers);

            System.out.printf("Количество чисел: %d%n", numbers.size());
            System.out.printf("Сумма чисел: %.4f%n", sum);
            System.out.printf("Среднее значение: %.4f%n", average);

            createResultFile(numbers, sum, average);

        } catch (InvalidNumberException e) {
            System.err.println("\nОШИБКА ОБРАБОТКИ ДАННЫХ:");
            System.err.println("  " + e.getMessage());
            if (e.getCause() != null) {
                System.err.println("  Причина: " + e.getCause().getMessage());
            }
        } catch (IOException e) {
            System.err.println("\nОШИБКА ВВОДА-ВЫВОДА:");
            System.err.println("  " + e.getMessage());
        } catch (OutOfMemoryError e) {
            System.err.println("\nОШИБКА ПАМЯТИ:");
            System.err.println("  " + e.getMessage());
            System.err.println("  Файл слишком большой для обработки");
        } catch (Exception e) {
            System.err.println("\nНЕПРЕДВИДЕННАЯ ОШИБКА:");
            System.err.println("  " + e.getMessage());
        }

        scanner.close();
    }

    private static void createResultFile(List<Double> numbers, double sum, double average) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("result.txt"))) {
            writer.println("РЕЗУЛЬТАТ ОБРАБОТКИ ФАЙЛА");
            writer.println("Количество чисел: " + numbers.size());
            writer.println("Сумма чисел: " + sum);
            writer.println("Среднее значение: " + average);
            writer.println("\nЧисла:");
            for (int i = 0; i < numbers.size(); i++) {
                writer.printf("  %d. %.4f%n", i + 1, numbers.get(i));
            }
            System.out.println("\nРезультат сохранён в файл: result.txt");
        } catch (IOException e) {
            System.err.println("Не удалось сохранить результат: " + e.getMessage());
        }
    }
}