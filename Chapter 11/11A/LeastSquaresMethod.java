import java.util.List;

public class LeastSquaresMethod {

    public static double calculateResistance(List<Double> currents, List<Double> voltages) {
        if (currents == null || voltages == null) {
            throw new IllegalArgumentException("Списки не могут быть null");
        }

        if (currents.size() != voltages.size()) {
            throw new IllegalArgumentException("Списки должны иметь одинаковый размер");
        }

        if (currents.isEmpty()) {
            throw new IllegalArgumentException("Списки не могут быть пустыми");
        }

        double sumI2 = 0.0;
        double sumIU = 0.0;

        for (int i = 0; i < currents.size(); i++) {
            double current = currents.get(i);
            double voltage = voltages.get(i);

            sumI2 += current * current;
            sumIU += current * voltage;
        }

        if (Math.abs(sumI2) < 1e-10) {
            throw new ArithmeticException("Сумма квадратов токов близка к нулю");
        }

        return sumIU / sumI2;
    }

    public static double calculateStandardDeviation(List<Double> currents, List<Double> voltages, double resistance) {
        if (currents.isEmpty()) {
            return 0.0;
        }

        double sumError = 0.0;

        for (int i = 0; i < currents.size(); i++) {
            double voltage = voltages.get(i);
            double current = currents.get(i);
            double expectedVoltage = current * resistance;
            double error = voltage - expectedVoltage;
            sumError += error * error;
        }

        return Math.sqrt(sumError / currents.size());
    }

    public static double calculateCorrelation(List<Double> currents, List<Double> voltages) {
        int n = currents.size();

        double sumI = 0.0;
        double sumU = 0.0;
        double sumI2 = 0.0;
        double sumU2 = 0.0;
        double sumIU = 0.0;

        for (int i = 0; i < n; i++) {
            double current = currents.get(i);
            double voltage = voltages.get(i);

            sumI += current;
            sumU += voltage;
            sumI2 += current * current;
            sumU2 += voltage * voltage;
            sumIU += current * voltage;
        }

        double numerator = n * sumIU - sumI * sumU;
        double denominator = Math.sqrt((n * sumI2 - sumI * sumI) * (n * sumU2 - sumU * sumU));

        if (Math.abs(denominator) < 1e-10) {
            return 0.0;
        }

        return numerator / denominator;
    }
}