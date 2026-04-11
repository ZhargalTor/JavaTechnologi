public class Symbol {
    private char value;

    public Symbol(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }

    public boolean isLetter() {
        return Character.isLetter(value);
    }

    public boolean isVowel() {
        char lower = Character.toLowerCase(value);
        return lower == 'а' || lower == 'е' || lower == 'ё' || lower == 'и' ||
                lower == 'о' || lower == 'у' || lower == 'ы' || lower == 'э' ||
                lower == 'ю' || lower == 'я' || lower == 'a' || lower == 'e' ||
                lower == 'i' || lower == 'o' || lower == 'u' || lower == 'y';
    }

    public boolean isPunctuation() {
        return !isLetter() && !Character.isWhitespace(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}