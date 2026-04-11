import java.util.ArrayList;
import java.util.List;

public class Paragraph {
    private List<Sentence> sentences;

    public Paragraph() {
        this.sentences = new ArrayList<>();
    }

    public void addSentence(Sentence sentence) {
        sentences.add(sentence);
    }

    public List<Sentence> getSentences() {
        return sentences;
    }

    public List<Word> getAllWords() {
        List<Word> words = new ArrayList<>();
        for (Sentence sentence : sentences) {
            words.addAll(sentence.getAllWords());
        }
        return words;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sentences.size(); i++) {
            sb.append(sentences.get(i));
            if (i < sentences.size() - 1) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }
}