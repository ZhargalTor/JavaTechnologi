import java.io.*;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class NumberReader {

    public static List<Double> readNumbersFromFile(String filename)
            throws InvalidNumberException, IOException {

        List<Double> numbers = new ArrayList<>();
        File file = new File(filename);

        if (!file.exists()) {
            throw new InvalidNumberException("Файл не найден: " + filename);
        }

        if (!file.canRead()) {
            throw new InvalidNumberException("Нет прав на чтение файла: " + filename);
        }

        if (file.length() == 0) {
            throw new InvalidNumberException("Файл пуст: " + filename);
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            int lineNumber = 0;

            while ((line = reader.readLine()) != null) {
                lineNumber++;
                line = line.trim();

                if (line.isEmpty()) {
                    continue;
                }

                String[] parts = line.split("\\|");

                if (parts.length != 2) {
                    throw new InvalidNumberException(
                            "Некорректный формат в строке " + lineNumber +
                                    ": ожидается 'число|локаль'");
                }

                String numberStr = parts[0].trim();
                String localeStr = parts[1].trim();

                double number = parseNumberWithLocale(numberStr, localeStr);

                if (Double.isInfinite(number)) {
                    throw new InvalidNumberException(
                            "Число в строке " + lineNumber + " выходит за пределы допустимых значений");
                }

                numbers.add(number);
            }
        } catch (OutOfMemoryError e) {
            throw new InvalidNumberException("Недостаточно памяти для обработки файла", e);
        }

        if (numbers.isEmpty()) {
            throw new InvalidNumberException("В файле не найдено корректных чисел");
        }

        return numbers;
    }

    private static double parseNumberWithLocale(String numberStr, String localeStr)
            throws InvalidNumberException {

        Locale locale;

        switch (localeStr.toLowerCase()) {
            case "ru":
            case "rus":
            case "russian":
                locale = new Locale("ru", "RU");
                break;
            case "us":
            case "en":
            case "english":
                locale = Locale.US;
                break;
            case "de":
            case "german":
                locale = Locale.GERMAN;
                break;
            case "fr":
            case "french":
                locale = Locale.FRENCH;
                break;
            default:
                throw new InvalidNumberException("Неизвестная локаль: " + localeStr);
        }

        try {
            NumberFormat format = NumberFormat.getInstance(locale);
            Number number = format.parse(numberStr);
            double value = number.doubleValue();

            if (Double.isNaN(value)) {
                throw new InvalidNumberException("Некорректное число: " + numberStr);
            }

            if (Math.abs(value) > 1e308) {
                throw new InvalidNumberException(
                        "Число " + value + " выходит за пределы допустимых значений");
            }

            return value;
        } catch (ParseException e) {
            throw new InvalidNumberException(
                    "Не удалось распарсить число '" + numberStr + "' с локалью " + localeStr, e);
        }
    }

    public static double calculateSum(List<Double> numbers) {
        double sum = 0;
        for (double num : numbers) {
            sum += num;
        }
        return sum;
    }

    public static double calculateAverage(List<Double> numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        return calculateSum(numbers) / numbers.size();
    }
}