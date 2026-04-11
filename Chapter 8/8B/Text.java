import java.util.ArrayList;
import java.util.List;

public class Text {
    private List<Paragraph> paragraphs;

    public Text() {
        this.paragraphs = new ArrayList<>();
    }

    public void addParagraph(Paragraph paragraph) {
        paragraphs.add(paragraph);
    }

    public List<Word> getAllWords() {
        List<Word> words = new ArrayList<>();
        for (Paragraph paragraph : paragraphs) {
            words.addAll(paragraph.getAllWords());
        }
        return words;
    }

    public static Text parse(String input) {
        String normalized = input.replaceAll("\\s+", " ");

        Text text = new Text();
        String[] paragraphParts = normalized.split("\\n\\s*\\n");

        for (String paraText : paragraphParts) {
            Paragraph paragraph = parseParagraph(paraText.trim());
            if (paragraph != null) {
                text.addParagraph(paragraph);
            }
        }

        return text;
    }

    private static Paragraph parseParagraph(String text) {
        if (text.isEmpty()) return null;

        Paragraph paragraph = new Paragraph();
        String[] sentencesParts = text.split("(?<=[.!?])\\s+");

        for (String sentenceText : sentencesParts) {
            Sentence sentence = parseSentence(sentenceText.trim());
            if (sentence != null) {
                paragraph.addSentence(sentence);
            }
        }

        return paragraph;
    }

    private static Sentence parseSentence(String text) {
        if (text.isEmpty()) return null;

        Sentence sentence = new Sentence();
        StringBuilder currentWord = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            if (Character.isLetter(c) || (c == '-' && currentWord.length() > 0)) {
                currentWord.append(c);
            } else {
                if (currentWord.length() > 0) {
                    Word word = new Word();
                    for (char ch : currentWord.toString().toCharArray()) {
                        word.addSymbol(new Symbol(ch));
                    }
                    sentence.addLexeme(new Lexeme(word));
                    currentWord = new StringBuilder();
                }

                if (c != ' ') {
                    sentence.addLexeme(new Lexeme(new Punctuation(c)));
                }
            }
        }

        if (currentWord.length() > 0) {
            Word word = new Word();
            for (char ch : currentWord.toString().toCharArray()) {
                word.addSymbol(new Symbol(ch));
            }
            sentence.addLexeme(new Lexeme(word));
        }

        return sentence;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < paragraphs.size(); i++) {
            sb.append(paragraphs.get(i));
            if (i < paragraphs.size() - 1) {
                sb.append("\n\n");
            }
        }
        return sb.toString();
    }
}