import java.util.Objects;

public class RationalFraction implements Comparable<RationalFraction> {
    private long numerator;
    private long denominator;

    public RationalFraction(long numerator, long denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен нулю");
        }
        this.numerator = numerator;
        this.denominator = denominator;
        normalize();
    }

    public RationalFraction(long value) {
        this(value, 1);
    }

    public RationalFraction() {
        this(0, 1);
    }

    public RationalFraction(RationalFraction other) {
        this(other.numerator, other.denominator);
    }

    private void normalize() {
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
        long gcd = gcd(Math.abs(numerator), denominator);
        numerator /= gcd;
        denominator /= gcd;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public long getNumerator() {
        return numerator;
    }

    public long getDenominator() {
        return denominator;
    }

    public void setNumerator(long numerator) {
        this.numerator = numerator;
        normalize();
    }

    public void setDenominator(long denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен нулю");
        }
        this.denominator = denominator;
        normalize();
    }

    public RationalFraction add(RationalFraction other) {
        long newNumerator = this.numerator * other.denominator + other.numerator * this.denominator;
        long newDenominator = this.denominator * other.denominator;
        return new RationalFraction(newNumerator, newDenominator);
    }

    public RationalFraction subtract(RationalFraction other) {
        long newNumerator = this.numerator * other.denominator - other.numerator * this.denominator;
        long newDenominator = this.denominator * other.denominator;
        return new RationalFraction(newNumerator, newDenominator);
    }

    public RationalFraction multiply(RationalFraction other) {
        return new RationalFraction(
                this.numerator * other.numerator,
                this.denominator * other.denominator
        );
    }

    public RationalFraction divide(RationalFraction other) {
        if (other.numerator == 0) {
            throw new ArithmeticException("Деление на ноль");
        }
        return new RationalFraction(
                this.numerator * other.denominator,
                this.denominator * other.numerator
        );
    }

    public RationalFraction square() {
        return new RationalFraction(
                numerator * numerator,
                denominator * denominator
        );
    }

    public double sqrt() {
        return Math.sqrt((double) numerator / denominator);
    }

    public double toDouble() {
        return (double) numerator / denominator;
    }

    @Override
    public int compareTo(RationalFraction other) {
        return Double.compare(this.toDouble(), other.toDouble());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        RationalFraction that = (RationalFraction) obj;
        return numerator == that.numerator && denominator == that.denominator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }

    @Override
    public String toString() {
        if (denominator == 1) {
            return Long.toString(numerator);
        }
        return numerator + "/" + denominator;
    }

    public String toDecimalString(int precision) {
        return String.format("%." + precision + "f", toDouble());
    }
}