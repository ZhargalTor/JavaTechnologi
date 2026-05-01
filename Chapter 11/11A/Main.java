/*7. Списки, стеки или очереди T(1..n) и U(1..n) содержат результаты nизмере-
        ний тока и напряжения на неизвестном сопротивлении R. Найти прибли-
        женное число R методом наименьших квадратов.*/
/*ТОРЯШИЕВ ЖАРГАЛ Б763-2А*/




import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("РАСЧЁТ СОПРОТИВЛЕНИЯ МЕТОДОМ НАИМЕНЬШИХ КВАДРАТОВ");

        List<Double> currents = new ArrayList<>();
        List<Double> voltages = new ArrayList<>();

        System.out.print("\nВведите количество измерений: ");
        int n = scanner.nextInt();

        System.out.println("\nВведите пары (ток, напряжение):");
        for (int i = 1; i <= n; i++) {
            System.out.printf("%d. Ток (А): ", i);
            double current = scanner.nextDouble();
            System.out.printf("   Напряжение (В): ");
            double voltage = scanner.nextDouble();

            currents.add(current);
            voltages.add(voltage);
        }

        System.out.println("ИСХОДНЫЕ ДАННЫЕ:");
        System.out.printf("%-5s | %-15s | %-15s%n", "№", "Ток I (А)", "Напряжение U (В)");

        for (int i = 0; i < currents.size(); i++) {
            System.out.printf("%-5d | %-15.6f | %-15.6f%n",
                    i + 1, currents.get(i), voltages.get(i));
        }

        try {
            double resistance = LeastSquaresMethod.calculateResistance(currents, voltages);
            double deviation = LeastSquaresMethod.calculateStandardDeviation(currents, voltages, resistance);
            double correlation = LeastSquaresMethod.calculateCorrelation(currents, voltages);

            System.out.println("РЕЗУЛЬТАТЫ РАСЧЁТА:");
            System.out.printf("Сопротивление R = %.4f Ом%n", resistance);
            System.out.printf("Стандартное отклонение = %.6f%n", deviation);
            System.out.printf("Коэффициент корреляции = %.6f%n", correlation);

            if (Math.abs(correlation) > 0.95) {
                System.out.println("  → Сильная линейная зависимость (данные соответствуют закону Ома)");
            } else if (Math.abs(correlation) > 0.7) {
                System.out.println("  → Средняя линейная зависимость");
            } else {
                System.out.println("  → Слабая линейная зависимость (проверьте измерения)");
            }

        } catch (Exception e) {
            System.err.println("Ошибка: " + e.getMessage());
        }

        scanner.close();
    }
}