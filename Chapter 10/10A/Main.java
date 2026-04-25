/*Вариант A
        В следующих заданиях требуется ввести последовательность строк из текс-
        тового потока и выполнить указанные действия. При этом могут рассматри-
        ваться два варианта:
        • каждая строка состоит из одного слова;
        • каждая строка состоит из нескольких слов.
        Имена входного и выходного файлов, а также абсолютный путь к ним могут
        быть введены как параметры командной строки или храниться в файле.
        7. В каждом слове повести Владимира Короткевича «Дикая охота короля
        Стаха» заменить первую букву слова на прописную.

ТОРЯШИЕВ ЖАРГАЛ Б763-2А*/





import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("=".repeat(80));
        System.out.println("ОБРАБОТКА ТЕКСТА");
        System.out.println("Повесть Владимира Короткевича «Дикая охота короля Стаха»");
        System.out.println("Замена первой буквы каждого слова на прописную");
        System.out.println("=".repeat(80));

        String inputFile = null;
        String outputFile = null;

        if (args.length >= 2) {
            inputFile = args[0];
            outputFile = args[1];
            System.out.println("Параметры из командной строки:");
            System.out.println("  Входной файл: " + inputFile);
            System.out.println("  Выходной файл: " + outputFile);
        } else {
            Scanner scanner = new Scanner(System.in);
            System.out.println("\nВведите параметры вручную:");
            System.out.print("Введите путь к входному файлу: ");
            inputFile = scanner.nextLine();
            System.out.print("Введите путь к выходному файлу: ");
            outputFile = scanner.nextLine();
            scanner.close();
        }

        if (inputFile == null || inputFile.trim().isEmpty()) {
            inputFile = "input.txt";
            System.out.println("Используем файл по умолчанию: input.txt");
        }

        if (outputFile == null || outputFile.trim().isEmpty()) {
            outputFile = "output.txt";
            System.out.println("Используем файл по умолчанию: output.txt");
        }

        System.out.println("\n" + "-".repeat(80));
        System.out.println("Начинаем обработку...");
        System.out.println("-".repeat(80));

        try {
            File input = new File(inputFile);
            if (!input.exists()) {
                System.err.println("Ошибка: Входной файл не найден: " + inputFile);
                return;
            }

            TextProcessor.processFile(inputFile, outputFile);

            System.out.println("\nОбработка завершена успешно!");
            System.out.println("Результат сохранён в файл: " + outputFile);

            System.out.println("\n" + "=".repeat(80));
            System.out.println("РЕЗУЛЬТАТ ОБРАБОТКИ (первые 10 строк):");
            System.out.println("=".repeat(80));

            showPreview(outputFile, 10);

        } catch (FileNotFoundException e) {
            System.err.println("Ошибка: Файл не найден - " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Ошибка ввода-вывода: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Непредвиденная ошибка: " + e.getMessage());
        }
    }

    private static void showPreview(String filename, int linesCount) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            int count = 0;

            while ((line = reader.readLine()) != null && count < linesCount) {
                System.out.println(line);
                count++;
            }

            if (count == 0) {
                System.out.println("(файл пуст)");
            } else if (reader.readLine() != null) {
                System.out.println("...");
            }

        } catch (IOException e) {
            System.err.println("Ошибка при чтении результата: " + e.getMessage());
        }
    }
}