public class Lexeme {
    private Word word;
    private Punctuation punctuation;

    public Lexeme(Word word) {
        this.word = word;
        this.punctuation = null;
    }

    public Lexeme(Punctuation punctuation) {
        this.word = null;
        this.punctuation = punctuation;
    }

    public boolean isWord() {
        return word != null;
    }

    public Word getWord() {
        return word;
    }

    public Punctuation getPunctuation() {
        return punctuation;
    }

    @Override
    public String toString() {
        if (isWord()) {
            return word.toString();
        } else {
            return punctuation.toString();
        }
    }
}