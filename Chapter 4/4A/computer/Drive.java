package computer;

import java.util.Objects;

public class Drive {
    private String type; // DVD, Blu-ray, CD
    private String model;
    private boolean hasDisc;
    private boolean isReading;

    public Drive(String type, String model) {
        this.type = type;
        this.model = model;
        this.hasDisc = false;
        this.isReading = false;
    }

    public Drive(String type, String model, boolean hasDisc) {
        this(type, model);
        this.hasDisc = hasDisc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public boolean hasDisc() {
        return hasDisc;
    }

    public void insertDisc() {
        if (!hasDisc) {
            hasDisc = true;
            System.out.println("  Диск вставлен в дисковод");
        } else {
            System.out.println("  В дисководе уже есть диск");
        }
    }

    public void ejectDisc() {
        if (hasDisc) {
            hasDisc = false;
            isReading = false;
            System.out.println("  Диск извлечен из дисковода");
        } else {
            System.out.println("  В дисководе нет диска");
        }
    }

    public void readDisc() {
        if (hasDisc) {
            isReading = true;
            System.out.println("  Чтение диска...");
            isReading = false;
        } else {
            System.out.println("  Невозможно прочитать: диск отсутствует");
        }
    }

    public boolean isReading() {
        return isReading;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Drive drive = (Drive) o;
        return hasDisc == drive.hasDisc &&
                isReading == drive.isReading &&
                Objects.equals(type, drive.type) &&
                Objects.equals(model, drive.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, model, hasDisc, isReading);
    }

    @Override
    public String toString() {
        return String.format("Дисковод: %s (%s) | Диск %s",
                model, type, hasDisc ? "вставлен" : "отсутствует");
    }
}