import java.io.*;
import java.util.*;

public class TextProcessor {

    public static void processFile(String inputFile, String outputFile) throws IOException {
        List<String> lines = readLines(inputFile);
        List<String> processedLines = new ArrayList<>();

        for (String line : lines) {
            String processedLine = processLine(line);
            processedLines.add(processedLine);
        }

        writeLines(outputFile, processedLines);
    }

    private static List<String> readLines(String filename) throws IOException {
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }

        return lines;
    }

    private static void writeLines(String filename, List<String> lines) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        }
    }

    private static String processLine(String line) {
        if (line == null || line.trim().isEmpty()) {
            return line;
        }

        String[] words = line.split("(?<=\\b)|(?=\\b)");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (isWord(word)) {
                result.append(capitalizeFirstLetter(word));
            } else {
                result.append(word);
            }
        }

        return result.toString();
    }

    private static boolean isWord(String token) {
        if (token == null || token.isEmpty()) {
            return false;
        }

        for (char c : token.toCharArray()) {
            if (Character.isLetter(c)) {
                return true;
            }
        }
        return false;
    }

    private static String capitalizeFirstLetter(String word) {
        if (word == null || word.isEmpty()) {
            return word;
        }

        char firstChar = word.charAt(0);

        if (Character.isLetter(firstChar)) {
            return Character.toUpperCase(firstChar) + word.substring(1);
        }

        return word;
    }
}