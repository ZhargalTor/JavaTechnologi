package service;

import model.rider.Motorcyclist;
import java.io.*;

public class FileService {
    private static final String DATA_FILE = "motorcyclist_data.ser";

    public static void saveToFile(Motorcyclist motorcyclist) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            oos.writeObject(motorcyclist);
            System.out.println("Данные успешно сохранены в файл: " + DATA_FILE);
        } catch (IOException e) {
            System.err.println("Ошибка при сохранении данных: " + e.getMessage());
        }
    }

    public static Motorcyclist loadFromFile() {
        File file = new File(DATA_FILE);
        if (!file.exists()) {
            System.out.println("Файл с данными не найден. Будет создан новый мотоциклист.");
            return null;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DATA_FILE))) {
            Motorcyclist motorcyclist = (Motorcyclist) ois.readObject();
            System.out.println("Данные успешно загружены из файла: " + DATA_FILE);
            return motorcyclist;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Ошибка при загрузке данных: " + e.getMessage());
            return null;
        }
    }
}