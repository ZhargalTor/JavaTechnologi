import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Triangle> triangles = new ArrayList<>();

        triangles.add(new Triangle(5, 5, 5));        // Равносторонний
        triangles.add(new Triangle(6, 6, 8));        // Равнобедренный
        triangles.add(new Triangle(3, 4, 5));        // Прямоугольный
        triangles.add(new Triangle(5, 6, 7));        // Произвольный
        triangles.add(new Triangle(4, 4, 6));        // Равнобедренный
        triangles.add(new Triangle(10, 10, 10));     // Равносторонний
        triangles.add(new Triangle(5, 12, 13));      // Прямоугольный
        triangles.add(new Triangle(7, 8, 9));        // Произвольный
        triangles.add(new Triangle(8, 8, 12));       // Равнобедренный
        triangles.add(new Triangle(6, 8, 10));       // Прямоугольный
        triangles.add(new Triangle(3, 3, 4));        // Равнобедренный
        triangles.add(new Triangle(9, 9, 9));        // Равносторонний

        System.out.println("СПИСОК ВСЕХ ТРЕУГОЛЬНИКОВ:");
        triangles.forEach(System.out::println);

        Map<TriangleType, List<Triangle>> trianglesByType = new HashMap<>();
        for (TriangleType type : TriangleType.values()) {
            trianglesByType.put(type, new ArrayList<>());
        }

        for (Triangle triangle : triangles) {
            TriangleType type = triangle.getType();
            trianglesByType.get(type).add(triangle);
        }

        System.out.println("СТАТИСТИКА ПО ТИПАМ ТРЕУГОЛЬНИКОВ:");

        for (TriangleType type : TriangleType.values()) {
            List<Triangle> typeTriangles = trianglesByType.get(type);
            int count = typeTriangles.size();
            System.out.printf("\n%s: %d треугольник(ов)%n", type.getDescription(), count);

            if (count > 0) {
                // Находим наибольший и наименьший по площади
                Triangle maxAreaTriangle = Collections.max(typeTriangles,
                        Comparator.comparingDouble(Triangle::getArea));
                Triangle minAreaTriangle = Collections.min(typeTriangles,
                        Comparator.comparingDouble(Triangle::getArea));

                // Находим наибольший и наименьший по периметру
                Triangle maxPerimeterTriangle = Collections.max(typeTriangles,
                        Comparator.comparingDouble(Triangle::getPerimeter));
                Triangle minPerimeterTriangle = Collections.min(typeTriangles,
                        Comparator.comparingDouble(Triangle::getPerimeter));

                System.out.println("  По площади:");
                System.out.printf("    Наибольший: %.2f (%s)%n",
                        maxAreaTriangle.getArea(), maxAreaTriangle.toShortString());
                System.out.printf("    Наименьший: %.2f (%s)%n",
                        minAreaTriangle.getArea(), minAreaTriangle.toShortString());

                System.out.println("  По периметру:");
                System.out.printf("    Наибольший: %.2f (%s)%n",
                        maxPerimeterTriangle.getPerimeter(), maxPerimeterTriangle.toShortString());
                System.out.printf("    Наименьший: %.2f (%s)%n",
                        minPerimeterTriangle.getPerimeter(), minPerimeterTriangle.toShortString());
            }
        }

        System.out.println("ДЕМОНСТРАЦИЯ АРИФМЕТИЧЕСКИХ ОПЕРАЦИЙ:");

        Triangle t1 = new Triangle(3, 4, 5);      // Площадь = 6.00
        Triangle t2 = new Triangle(5, 5, 5);      // Площадь ≈ 10.83

        System.out.println("Исходные треугольники:");
        System.out.println("  T1: " + t1.toShortString());
        System.out.println("  T2: " + t2.toShortString());

        Triangle sum = t1.add(t2);
        System.out.printf("\nСложение (T1 + T2): Площадь = %.2f + %.2f = %.2f%n",
                t1.getArea(), t2.getArea(), sum.getArea());
        System.out.println("  Результат: " + sum.toShortString());

        Triangle diff = t1.subtract(t2);
        System.out.printf("\nВычитание (|T1 - T2|): Площадь = |%.2f - %.2f| = %.2f%n",
                t1.getArea(), t2.getArea(), diff.getArea());
        System.out.println("  Результат: " + diff.toShortString());

        double scalar = 2.5;
        Triangle product = t1.multiply(scalar);
        System.out.printf("\nУмножение (T1 × %.2f): Площадь = %.2f × %.2f = %.2f%n",
                scalar, t1.getArea(), scalar, product.getArea());
        System.out.println("  Результат: " + product.toShortString());

        Triangle quotient = t1.divide(scalar);
        System.out.printf("\nДеление (T1 / %.2f): Площадь = %.2f / %.2f = %.2f%n",
                scalar, t1.getArea(), scalar, quotient.getArea());
        System.out.println("  Результат: " + quotient.toShortString());

        System.out.println("Дополнительные операции:");

        Triangle t3 = new Triangle(6, 8, 10);     // Площадь = 24.00
        System.out.println("  T3: " + t3.toShortString());

        Triangle sum2 = t2.add(t3);
        System.out.printf("  T2 + T3: %.2f + %.2f = %.2f%n",
                t2.getArea(), t3.getArea(), sum2.getArea());

        Triangle diff2 = t3.subtract(t2);
        System.out.printf("  T3 - T2: %.2f - %.2f = %.2f%n",
                t3.getArea(), t2.getArea(), diff2.getArea());

        System.out.println("РАБОТА С МНОЖЕСТВОМ ТРЕУГОЛЬНИКОВ:");

        Set<Triangle> triangleSet = new HashSet<>();
        triangleSet.add(new Triangle(3, 4, 5));
        triangleSet.add(new Triangle(5, 5, 5));
        triangleSet.add(new Triangle(6, 8, 10));
        triangleSet.add(new Triangle(3, 4, 5)); // дубликат, не добавится

        System.out.println("Количество уникальных треугольников: " + triangleSet.size());
        triangleSet.forEach(t -> System.out.println("  " + t.toShortString()));

        System.out.println("ПРОВЕРКА ВАЛИДАЦИИ:");

        try {
            Triangle invalid = new Triangle(1, 1, 3);
        } catch (IllegalArgumentException e) {
            System.out.println("  Ошибка: " + e.getMessage());
        }

        try {
            Triangle t = new Triangle(2, 2, 2);
            t.divide(0);
        } catch (IllegalArgumentException e) {
            System.out.println("  Ошибка: " + e.getMessage());
        }
    }
}