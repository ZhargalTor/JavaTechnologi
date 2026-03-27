public class Main {
    public static void main(String[] args) {
        System.out.println("ДЕМОНСТРАЦИЯ РАБОТЫ С РАЦИОНАЛЬНЫМИ ДРОБЯМИ:");

        RationalFraction r1 = new RationalFraction(3, 4);
        RationalFraction r2 = new RationalFraction(1, 2);

        System.out.println("r1 = " + r1);
        System.out.println("r2 = " + r2);
        System.out.println("r1 + r2 = " + r1.add(r2));
        System.out.println("r1 - r2 = " + r1.subtract(r2));
        System.out.println("r1 * r2 = " + r1.multiply(r2));
        System.out.println("r1 / r2 = " + r1.divide(r2));
        System.out.println("r1 в квадрате = " + r1.square());
        System.out.println("r1 в десятичном виде: " + r1.toDecimalString(4));

        System.out.println("РАБОТА С ТОЧКАМИ В ПРОСТРАНСТВЕ:");

        Point3D p1 = new Point3D(new RationalFraction(1, 2), new RationalFraction(3, 4), new RationalFraction(5, 6));
        Point3D p2 = new Point3D(1, 2, 3);
        Point3D p3 = new Point3D(2, 3, 4);
        Point3D p4 = new Point3D(3, 4, 5);
        Point3D p5 = new Point3D(0, 0, 0);

        System.out.println("Точка P1 (рациональные дроби): " + p1.toRationalString());
        System.out.println("Точка P1 (десятичные): " + p1);
        System.out.println("Точка P2: " + p2);
        System.out.println("Точка P3: " + p3);
        System.out.println("Точка P4: " + p4);
        System.out.println("Точка P5 (начало координат): " + p5);

        System.out.println("РАССТОЯНИЯ:");

        System.out.printf("Расстояние от P1 до начала координат: %.6f%n", p1.distanceToOrigin());
        System.out.printf("Расстояние от P2 до начала координат: %.6f%n", p2.distanceToOrigin());
        System.out.printf("Расстояние от P3 до начала координат: %.6f%n", p3.distanceToOrigin());

        System.out.printf("Расстояние между P2 и P3: %.6f%n", p2.distanceTo(p3));
        System.out.printf("Расстояние между P3 и P4: %.6f%n", p3.distanceTo(p4));
        System.out.printf("Расстояние между P2 и P4: %.6f%n", p2.distanceTo(p4));

        System.out.println("ПРОВЕРКА ТОЧЕК НА КОЛЛИНЕАРНОСТЬ (ЛЕЖАНИЕ НА ОДНОЙ ПРЯМОЙ):");

        Point3D collinear1 = new Point3D(0, 0, 0);
        Point3D collinear2 = new Point3D(1, 1, 1);
        Point3D collinear3 = new Point3D(2, 2, 2);

        System.out.println("Тест 1 - Точки на одной прямой:");
        System.out.println("  " + collinear1);
        System.out.println("  " + collinear2);
        System.out.println("  " + collinear3);
        boolean result1 = Point3D.areCollinear(collinear1, collinear2, collinear3);
        System.out.println("  Результат: " + (result1 ? "ТОЧКИ ЛЕЖАТ НА ОДНОЙ ПРЯМОЙ" : "ТОЧКИ НЕ ЛЕЖАТ НА ОДНОЙ ПРЯМОЙ"));

        Point3D collinear4 = new Point3D(0, 0, 0);
        Point3D collinear5 = new Point3D(2, 4, 6);
        Point3D collinear6 = new Point3D(3, 6, 9);

        System.out.println("\nТест 2 - Точки на одной прямой (пропорциональные координаты):");
        System.out.println("  " + collinear4);
        System.out.println("  " + collinear5);
        System.out.println("  " + collinear6);
        boolean result2 = Point3D.areCollinear(collinear4, collinear5, collinear6);
        System.out.println("  Результат: " + (result2 ? "ТОЧКИ ЛЕЖАТ НА ОДНОЙ ПРЯМОЙ" : "ТОЧКИ НЕ ЛЕЖАТ НА ОДНОЙ ПРЯМОЙ"));

        Point3D nonCollinear1 = new Point3D(0, 0, 0);
        Point3D nonCollinear2 = new Point3D(1, 0, 0);
        Point3D nonCollinear3 = new Point3D(0, 1, 0);

        System.out.println("\nТест 3 - Точки не на одной прямой (образуют треугольник):");
        System.out.println("  " + nonCollinear1);
        System.out.println("  " + nonCollinear2);
        System.out.println("  " + nonCollinear3);
        boolean result3 = Point3D.areCollinear(nonCollinear1, nonCollinear2, nonCollinear3);
        System.out.println("  Результат: " + (result3 ? "ТОЧКИ ЛЕЖАТ НА ОДНОЙ ПРЯМОЙ" : "ТОЧКИ НЕ ЛЕЖАТ НА ОДНОЙ ПРЯМОЙ"));

        Point3D rationalCollinear1 = new Point3D(
                new RationalFraction(1, 2),
                new RationalFraction(1, 3),
                new RationalFraction(1, 4)
        );
        Point3D rationalCollinear2 = new Point3D(
                new RationalFraction(1, 1),
                new RationalFraction(2, 3),
                new RationalFraction(1, 2)
        );
        Point3D rationalCollinear3 = new Point3D(
                new RationalFraction(3, 2),
                new RationalFraction(1, 1),
                new RationalFraction(3, 4)
        );

        System.out.println("\nТест 4 - Точки с рациональными дробями на одной прямой:");
        System.out.println("  " + rationalCollinear1.toRationalString());
        System.out.println("  " + rationalCollinear2.toRationalString());
        System.out.println("  " + rationalCollinear3.toRationalString());
        boolean result4 = Point3D.areCollinear(rationalCollinear1, rationalCollinear2, rationalCollinear3);
        System.out.println("  Результат: " + (result4 ? "ТОЧКИ ЛЕЖАТ НА ОДНОЙ ПРЯМОЙ" : "ТОЧКИ НЕ ЛЕЖАТ НА ОДНОЙ ПРЯМОЙ"));

        Point3D samePoint1 = new Point3D(1, 2, 3);
        Point3D samePoint2 = new Point3D(1, 2, 3);
        Point3D differentPoint = new Point3D(4, 5, 6);

        System.out.println("\nТест 5 - Две точки совпадают (всегда коллинеарны):");
        System.out.println("  " + samePoint1);
        System.out.println("  " + samePoint2);
        System.out.println("  " + differentPoint);
        boolean result5 = Point3D.areCollinear(samePoint1, samePoint2, differentPoint);
        System.out.println("  Результат: " + (result5 ? "ТОЧКИ ЛЕЖАТ НА ОДНОЙ ПРЯМОЙ" : "ТОЧКИ НЕ ЛЕЖАТ НА ОДНОЙ ПРЯМОЙ"));

        System.out.println("ДОПОЛНИТЕЛЬНЫЕ ПРОВЕРКИ:");

        System.out.println("\n1. Точки на оси X:");
        Point3D x1 = new Point3D(0, 0, 0);
        Point3D x2 = new Point3D(5, 0, 0);
        Point3D x3 = new Point3D(10, 0, 0);
        System.out.println("  " + x1 + ", " + x2 + ", " + x3);
        System.out.println("  Результат: " + (Point3D.areCollinear(x1, x2, x3) ? "Коллинеарны" : "Не коллинеарны"));

        System.out.println("\n2. Точки на плоскости XY (Z=0):");
        Point3D xy1 = new Point3D(0, 0, 0);
        Point3D xy2 = new Point3D(2, 3, 0);
        Point3D xy3 = new Point3D(4, 6, 0);
        System.out.println("  " + xy1 + ", " + xy2 + ", " + xy3);
        System.out.println("  Результат: " + (Point3D.areCollinear(xy1, xy2, xy3) ? "Коллинеарны" : "Не коллинеарны"));

        System.out.println("\n3. Точки в пространстве (общий случай):");
        Point3D space1 = new Point3D(1, 2, 3);
        Point3D space2 = new Point3D(4, 5, 6);
        Point3D space3 = new Point3D(7, 8, 10);
        System.out.println("  " + space1 + ", " + space2 + ", " + space3);
        System.out.println("  Результат: " + (Point3D.areCollinear(space1, space2, space3) ? "Коллинеарны" : "Не коллинеарны"));

        System.out.println("РАБОТА С РАЦИОНАЛЬНЫМИ ДРОБЯМИ В ТОЧКАХ:");

        Point3D rationalPoint = new Point3D(
                new RationalFraction(2, 3),
                new RationalFraction(5, 7),
                new RationalFraction(8, 11)
        );
        System.out.println("Точка с рациональными координатами: " + rationalPoint.toRationalString());
        System.out.println("В десятичном виде: " + rationalPoint);
        System.out.printf("Расстояние до начала координат: %.6f%n", rationalPoint.distanceToOrigin());

        Point3D intPoint = new Point3D(10, 20, 30);
        System.out.println("\nТочка с целыми координатами: " + intPoint);
        System.out.printf("Расстояние до начала координат: %.6f%n", intPoint.distanceToOrigin());
        System.out.printf("Расстояние до рациональной точки: %.6f%n", intPoint.distanceTo(rationalPoint));
    }
}