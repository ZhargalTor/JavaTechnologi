import java.util.ArrayList;
import java.util.List;

public class Sentence {
    private List<Lexeme> lexemes;

    public Sentence() {
        this.lexemes = new ArrayList<>();
    }

    public void addLexeme(Lexeme lexeme) {
        lexemes.add(lexeme);
    }

    public List<Word> getWords() {
        List<Word> words = new ArrayList<>();
        for (Lexeme lexeme : lexemes) {
            if (lexeme.isWord()) {
                words.add(lexeme.getWord());
            }
        }
        return words;
    }

    public List<Word> getAllWords() {
        return getWords();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lexemes.size(); i++) {
            sb.append(lexemes.get(i));
            if (i < lexemes.size() - 1 && lexemes.get(i).isWord() &&
                    lexemes.get(i + 1).isWord()) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }
}