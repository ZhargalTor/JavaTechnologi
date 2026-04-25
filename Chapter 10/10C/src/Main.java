import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        String inputFile = "input.txt";

        File dir = new File("result");
        if (!dir.exists()) {
            dir.mkdir();
        }

        File outputFile = new File(dir, "output.txt");

        try (
                BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))
        ) {

            String line;

            while ((line = reader.readLine()) != null) {
                String processed = processLine(line);
                writer.write(processed);
                writer.newLine();
            }

            System.out.println("Готово! Файл: " + outputFile.getAbsolutePath());

        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден");

        } catch (IOException e) {
            System.err.println("Ошибка ввода/вывода: " + e.getMessage());
        }
    }

    private static String processLine(String line) {

        String[] words = line.split("\\s+");

        List<Integer> indexesToRemove = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            int len = words[i].length();
            if (len >= 3 && len <= 5) {
                indexesToRemove.add(i);
            }
        }

        int removeCount = indexesToRemove.size();
        if (removeCount % 2 != 0) {
            removeCount--;
        }

        Set<Integer> toRemove = new HashSet<>();
        for (int i = 0; i < removeCount; i++) {
            toRemove.add(indexesToRemove.get(i));
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            if (!toRemove.contains(i)) {
                result.append(words[i]).append(" ");
            }
        }

        return result.toString().trim();
    }
}