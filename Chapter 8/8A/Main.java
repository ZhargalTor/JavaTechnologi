//7. Из текста удалить все символы, кроме пробелов, не являющиеся буквами. Между
//   последовательностями подряд идущих букв оставить хотя бы один пробел.
//ТОРЯШИЕВ ЖАРГАЛ Б763-2А


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите текст для удаление символов кроме букв и пробелов: ");
        String input = scanner.nextLine();

        String result = processText(input);

        System.out.println("\n=== РЕЗУЛЬТАТ ===");
        System.out.println(result);

        scanner.close();
    }

    public static String processText(String text) {
        StringBuilder result = new StringBuilder();
        boolean previousIsLetter = false;

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            if (Character.isLetter(c)) {
                result.append(c);
                previousIsLetter = true;
            }
            else if (c == ' ') {
                if (previousIsLetter) {
                    result.append(' ');
                    previousIsLetter = false;
                }
            }
        }

        String trimmed = result.toString().trim();

        return trimmed.isEmpty() ? " (пусто)" : trimmed;
    }
}