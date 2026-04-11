import java.util.ArrayList;
import java.util.List;

public class Word {
    private List<Symbol> symbols;

    public Word() {
        this.symbols = new ArrayList<>();
    }

    public void addSymbol(Symbol symbol) {
        if (symbol.isLetter()) {
            symbols.add(symbol);
        }
    }

    public String getValue() {
        StringBuilder sb = new StringBuilder();
        for (Symbol s : symbols) {
            sb.append(s.getValue());
        }
        return sb.toString();
    }

    public int getLength() {
        return symbols.size();
    }

    public int getVowelCount() {
        int count = 0;
        for (Symbol s : symbols) {
            if (s.isVowel()) {
                count++;
            }
        }
        return count;
    }

    public double getVowelRatio() {
        if (symbols.isEmpty()) {
            return 0.0;
        }
        return (double) getVowelCount() / getLength();
    }

    @Override
    public String toString() {
        return getValue();
    }
}