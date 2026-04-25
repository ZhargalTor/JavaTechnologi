package connector;

import model.rider.Motorcyclist;
import java.io.*;

public class FileConnector {

    public static void saveMotorcyclist(String filename, Motorcyclist motorcyclist) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(motorcyclist);
            System.out.println("Данные сохранены в файл: " + filename);
        }
    }

    public static Motorcyclist loadMotorcyclist(String filename) throws IOException, ClassNotFoundException {
        File file = new File(filename);
        if (!file.exists()) {
            return null;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            Motorcyclist motorcyclist = (Motorcyclist) ois.readObject();
            System.out.println("Данные загружены из файла: " + filename);
            return motorcyclist;
        }
    }

    public static boolean deleteFile(String filename) {
        File file = new File(filename);
        return file.exists() && file.delete();
    }

    public static boolean fileExists(String filename) {
        return new File(filename).exists();
    }
}