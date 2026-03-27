package computer;

import java.util.Objects;

public class Processor {
    private String model;
    private int cores;
    private double frequency; // в гигагерцах
    private boolean isRunning;

    public Processor(String model, int cores, double frequency) {
        this.model = model;
        this.cores = cores;
        this.frequency = frequency;
        this.isRunning = false;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCores() {
        return cores;
    }

    public void setCores(int cores) {
        if (cores > 0) {
            this.cores = cores;
        }
    }

    public double getFrequency() {
        return frequency;
    }

    public void setFrequency(double frequency) {
        if (frequency > 0) {
            this.frequency = frequency;
        }
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void start() {
        isRunning = true;
        System.out.println("  Процессор запущен");
    }

    public void stop() {
        isRunning = false;
        System.out.println("  Процессор остановлен");
    }

    public void executeTask(String task) {
        if (isRunning) {
            System.out.printf("  Процессор выполняет задачу: %s%n", task);
        } else {
            System.out.println("  Процессор не запущен");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Processor processor = (Processor) o;
        return cores == processor.cores &&
                Double.compare(frequency, processor.frequency) == 0 &&
                isRunning == processor.isRunning &&
                Objects.equals(model, processor.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, cores, frequency, isRunning);
    }

    @Override
    public String toString() {
        return String.format("Процессор: %s | Ядра: %d | Частота: %.1f GHz | Состояние: %s",
                model, cores, frequency, isRunning ? "работает" : "остановлен");
    }
}