//Создать программу обработки текста учебника по программированию с ис-
//        пользованием классов: Символ, Слово, Предложение, Абзац, Лексема, Листинг,
//        Знак препинания и др. Во всех задачах с формированием текста заменять табу-
//        ляции и последовательности пробелов одним пробелом.
//        Предварительно текст следует разобрать на составные части, выполнить
//        одно из перечисленных ниже заданий и вывести полученный результат.
//        7. Рассортировать слова текста по возрастанию доли гласных букв (отноше-
//        ние количества гласных к общему количеству букв в слове).
//ТОРЯШИЕВ ЖАРГАЛ Б763-2А


import java.util.*;

public class Main {
    public static void main(String[] args) {
        String textbook = """
                Программирование - это процесс создания компьютерных программ. 
                Языки программирования бывают разные: Python, Java, C++, JavaScript.
                
                Алгоритмы и структуры данных - основа программирования. 
                Изучение программирования требует терпения и практики.
                
                Объектно-ориентированное программирование позволяет создавать гибкие и переиспользуемые решения.
                """;

        System.out.println("ОБРАБОТКА ТЕКСТА УЧЕБНИКА ПО ПРОГРАММИРОВАНИЮ");

        System.out.println("\nИСХОДНЫЙ ТЕКСТ:");
        System.out.println(textbook);

        Text text = Text.parse(textbook);

        List<Word> allWords = text.getAllWords();

        System.out.println("СЛОВА, ОТСОРТИРОВАННЫЕ ПО ВОЗРАСТАНИЮ ДОЛИ ГЛАСНЫХ БУКВ:" + "\n");

        List<Word> sortedWords = new ArrayList<>(allWords);
        sortedWords.sort(Comparator.comparingDouble(Word::getVowelRatio));

        System.out.printf("%-30s | %-15s | %-10s | %-10s%n",
                "СЛОВО", "КОЛ-ВО БУКВ", "КОЛ-ВО ГЛАСНЫХ", "ДОЛЯ ГЛАСНЫХ");
        System.out.println("-".repeat(80));

        for (Word word : sortedWords) {
            System.out.printf("%-30s | %-15d | %-10d | %-10.3f%n",
                    word.getValue(),
                    word.getLength(),
                    word.getVowelCount(),
                    word.getVowelRatio());
        }

        System.out.println("\n" + "СТАТИСТИКА:");
        System.out.println("Всего слов в тексте: " + allWords.size());

        double minRatio = sortedWords.isEmpty() ? 0 : sortedWords.get(0).getVowelRatio();
        double maxRatio = sortedWords.isEmpty() ? 0 : sortedWords.get(sortedWords.size() - 1).getVowelRatio();

        System.out.printf("Минимальная доля гласных: %.3f%n", minRatio);
        System.out.printf("Максимальная доля гласных: %.3f%n", maxRatio);

        System.out.println("ДЕМОНСТРАЦИЯ РАБОТЫ КЛАССОВ:");

        Word exampleWord = new Word();
        for (char c : "Программирование".toCharArray()) {
            exampleWord.addSymbol(new Symbol(c));
        }
        System.out.println("Слово: " + exampleWord);
        System.out.println("Количество букв: " + exampleWord.getLength());
        System.out.println("Количество гласных: " + exampleWord.getVowelCount());
        System.out.printf("Доля гласных: %.3f%n", exampleWord.getVowelRatio());
    }
}