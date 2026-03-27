public class Triangle {

    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle(double sideA, double sideB, double sideC) {
        if (!isValidTriangle(sideA, sideB, sideC)) {
            throw new IllegalArgumentException("Некорректные стороны треугольника: " +
                    sideA + ", " + sideB + ", " + sideC);
        }
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public Triangle(Triangle other) {
        this(other.sideA, other.sideB, other.sideC);
    }

    private static boolean isValidTriangle(double a, double b, double c) {
        return a > 0 && b > 0 && c > 0 &&
                a + b > c && a + c > b && b + c > a;
    }

    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public double getSideC() {
        return sideC;
    }

    public void setSideA(double sideA) {
        if (isValidTriangle(sideA, this.sideB, this.sideC)) {
            this.sideA = sideA;
        } else {
            throw new IllegalArgumentException("Некорректная сторона A");
        }
    }

    public void setSideB(double sideB) {
        if (isValidTriangle(this.sideA, sideB, this.sideC)) {
            this.sideB = sideB;
        } else {
            throw new IllegalArgumentException("Некорректная сторона B");
        }
    }

    public void setSideC(double sideC) {
        if (isValidTriangle(this.sideA, this.sideB, sideC)) {
            this.sideC = sideC;
        } else {
            throw new IllegalArgumentException("Некорректная сторона C");
        }
    }

    public double getPerimeter() {
        return sideA + sideB + sideC;
    }

    public double getArea() {
        double p = getPerimeter() / 2;
        return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
    }

    public TriangleType getType() {
        double epsilon = 1e-10;

        if (Math.abs(sideA - sideB) < epsilon && Math.abs(sideB - sideC) < epsilon) {
            return TriangleType.EQUILATERAL;
        }

        if (Math.abs(sideA - sideB) < epsilon ||
                Math.abs(sideA - sideC) < epsilon ||
                Math.abs(sideB - sideC) < epsilon) {
            return TriangleType.ISOSCELES;
        }

        double[] sides = {sideA, sideB, sideC};
        java.util.Arrays.sort(sides);
        if (Math.abs(sides[2] * sides[2] - (sides[0] * sides[0] + sides[1] * sides[1])) < epsilon) {
            return TriangleType.RIGHT;
        }

        return TriangleType.SCALENE;
    }

    public Triangle add(Triangle other) {
        // Создаем треугольник, площадь которого равна сумме площадей
        double newArea = this.getArea() + other.getArea();
        return createTriangleByArea(newArea);
    }

    public Triangle subtract(Triangle other) {
        double newArea = Math.abs(this.getArea() - other.getArea());
        return createTriangleByArea(newArea);
    }

    public Triangle multiply(double scalar) {
        if (scalar <= 0) {
            throw new IllegalArgumentException("Скаляр должен быть положительным");
        }
        double newArea = this.getArea() * scalar;
        return createTriangleByArea(newArea);
    }

    public Triangle divide(double scalar) {
        if (scalar <= 0) {
            throw new IllegalArgumentException("Скаляр должен быть положительным");
        }
        double newArea = this.getArea() / scalar;
        return createTriangleByArea(newArea);
    }

    private Triangle createTriangleByArea(double area) {
        // Создаем равносторонний треугольник с заданной площадью
        // Площадь равностороннего треугольника: S = (√3/4) * a²
        // Отсюда a = √(4S/√3)
        double side = Math.sqrt(4 * area / Math.sqrt(3));
        return new Triangle(side, side, side);
    }

    public int compareByArea(Triangle other) {
        return Double.compare(this.getArea(), other.getArea());
    }

    public int compareByPerimeter(Triangle other) {
        return Double.compare(this.getPerimeter(), other.getPerimeter());
    }

    @Override
    public String toString() {
        return String.format("Треугольник [%.2f, %.2f, %.2f] | Периметр: %.2f | Площадь: %.2f | Тип: %s",
                sideA, sideB, sideC, getPerimeter(), getArea(), getType());
    }

    public String toShortString() {
        return String.format("Стороны: %.2f, %.2f, %.2f | Площадь: %.2f | Тип: %s",
                sideA, sideB, sideC, getArea(), getType());
    }
}