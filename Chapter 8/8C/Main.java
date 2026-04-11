//7. Определить, удовлетворяет ли имя файла маске. Маска может содержать
//        символы «?» (произвольный символ) и «*» (произвольное количество про-
//        извольных символов).
//ТОРЯШИЕВ ЖАРГАЛ Б763-2А

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("ПРОВЕРКА ИМЕНИ ФАЙЛА НА СООТВЕТСТВИЕ МАСКЕ");
        System.out.println("Символ '?' - заменяет ровно один любой символ");
        System.out.println("Символ '*' - заменяет любое количество любых символов");

        System.out.print("Введите маску: ");
        String mask = scanner.nextLine();

        System.out.print("Введите имя файла: ");
        String filename = scanner.nextLine();

        boolean result = matchesMask(filename, mask);

        System.out.println("РЕЗУЛЬТАТ:");
        System.out.println("Маска: " + mask);
        System.out.println("Имя файла: " + filename);

        if (result) {
            System.out.println("\n Имя файла СООТВЕТСТВУЕТ маске");
        } else {
            System.out.println("\n Имя файла НЕ СООТВЕТСТВУЕТ маске");
        }

        scanner.close();
    }

    public static boolean matchesMask(String filename, String mask) {
        return matchesMaskRecursive(filename, mask, 0, 0);
    }

    private static boolean matchesMaskRecursive(String filename, String mask,
                                                int fileIndex, int maskIndex) {
        if (maskIndex == mask.length()) {
            return fileIndex == filename.length();
        }

        if (fileIndex == filename.length()) {
            while (maskIndex < mask.length() && mask.charAt(maskIndex) == '*') {
                maskIndex++;
            }
            return maskIndex == mask.length();
        }

        char maskChar = mask.charAt(maskIndex);
        char fileChar = filename.charAt(fileIndex);

        if (maskChar == '*') {
            return matchesMaskRecursive(filename, mask, fileIndex, maskIndex + 1) ||
                    matchesMaskRecursive(filename, mask, fileIndex + 1, maskIndex);
        }

        if (maskChar == '?') {
            return matchesMaskRecursive(filename, mask, fileIndex + 1, maskIndex + 1);
        }

        if (maskChar == fileChar) {
            return matchesMaskRecursive(filename, mask, fileIndex + 1, maskIndex + 1);
        }

        return false;
    }
}