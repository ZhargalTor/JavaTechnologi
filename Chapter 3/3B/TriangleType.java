public enum TriangleType {
    EQUILATERAL("Равносторонний"),
    ISOSCELES("Равнобедренный"),
    RIGHT("Прямоугольный"),
    SCALENE("Произвольный");

    private final String description;

    TriangleType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return description;
    }
}