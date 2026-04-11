public class Punctuation {
    private Symbol symbol;

    public Punctuation(char symbol) {
        this.symbol = new Symbol(symbol);
    }

    public char getValue() {
        return symbol.getValue();
    }

    @Override
    public String toString() {
        return String.valueOf(symbol.getValue());
    }
}