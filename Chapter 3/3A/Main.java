import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Phone[] phones = new Phone[8];

        phones[0] = new Phone(1, "Иванов", "Иван", "Иванович",
                "ул. Ленина, д. 1", "1234-5678-9012-3456",
                1500.0, 500.0, 125.5, 45.2);

        phones[1] = new Phone(2, "Петров", "Петр", "Петрович",
                "ул. Гагарина, д. 15", "2345-6789-0123-4567",
                800.0, 200.0, 80.0, 0.0);

        phones[2] = new Phone(3, "Сидорова", "Анна", "Игоревна",
                "пр. Мира, д. 23", "3456-7890-1234-5678",
                2500.0, 1000.0, 210.3, 120.5);

        phones[3] = new Phone(4, "Козлов", "Дмитрий", "Алексеевич",
                "ул. Советская, д. 8", "4567-8901-2345-6789",
                500.0, 150.0, 45.0, 0.0);

        phones[4] = new Phone(5, "Новикова", "Елена", "Владимировна",
                "ул. Пушкина, д. 45", "5678-9012-3456-7890",
                3200.0, 800.0, 185.7, 95.3);

        phones[5] = new Phone(6, "Морозов", "Александр", "Сергеевич",
                "пер. Школьный, д. 3", 0.0, 0.0);
        phones[5].setLocalCallTime(67.8);
        phones[5].setLongDistanceCallTime(15.5);
        phones[5].setDebit(1200.0);
        phones[5].setCredit(400.0);

        phones[6] = new Phone(7, "Волков", "Андрей", "Николаевич",
                "ул. Лесная, д. 12", "6789-0123-4567-8901",
                1800.0, 600.0, 95.0, 0.0);

        phones[7] = new Phone(8, "Соколова", "Мария", "Дмитриевна",
                "ул. Цветочная, д. 7", 150.5, 45.8);

        System.out.println("СПИСОК ВСЕХ АБОНЕНТОВ:");
        printAllPhones(phones);

        double givenTime = 100.0;

        System.out.printf("a) АБОНЕНТЫ С ВРЕМЕНЕМ ГОРОДСКИХ РАЗГОВОРОВ > %.1f МИНУТ:%n", givenTime);
        findSubscribersWithLocalCallsAbove(phones, givenTime);

        System.out.println("b) АБОНЕНТЫ, ПОЛЬЗОВАВШИЕСЯ МЕЖДУГОРОДНОЙ СВЯЗЬЮ:");
        findSubscribersWithLongDistanceCalls(phones);

        System.out.println("c) АБОНЕНТЫ В АЛФАВИТНОМ ПОРЯДКЕ:");
        printSubscribersAlphabetically(phones);
    }

    public static void printAllPhones(Phone[] phones) {
        for (Phone phone : phones) {
            System.out.println(phone);
        }
    }

    public static void findSubscribersWithLocalCallsAbove(Phone[] phones, double limit) {
        boolean found = false;

        for (Phone phone : phones) {
            if (phone.getLocalCallTime() > limit) {
                System.out.println(phone.toShortString());
                found = true;
            }
        }

        if (!found) {
            System.out.println("Абоненты с временем городских разговоров более "
                    + limit + " минут не найдены.");
        }
    }

    public static void findSubscribersWithLongDistanceCalls(Phone[] phones) {
        boolean found = false;

        for (Phone phone : phones) {
            if (phone.hasLongDistanceCalls()) {
                System.out.println(phone.toShortString());
                System.out.println("   Использовано междугородных минут: "
                        + phone.getLongDistanceCallTime());
                found = true;
            }
        }

        if (!found) {
            System.out.println("Абоненты, пользовавшиеся междугородной связью, не найдены.");
        }
    }

    public static void printSubscribersAlphabetically(Phone[] phones) {

        Phone[] sortedPhones = Arrays.copyOf(phones, phones.length);

        for (int i = 0; i < sortedPhones.length - 1; i++) {
            for (int j = 0; j < sortedPhones.length - i - 1; j++) {
                if (sortedPhones[j].getLastName().compareToIgnoreCase(
                        sortedPhones[j + 1].getLastName()) > 0) {
                    Phone temp = sortedPhones[j];
                    sortedPhones[j] = sortedPhones[j + 1];
                    sortedPhones[j + 1] = temp;
                }
            }
        }

        System.out.println("Абоненты в алфавитном порядке по фамилии:");
        for (int i = 0; i < sortedPhones.length; i++) {
            System.out.printf("%d. %s%n", i + 1, sortedPhones[i].getFullName());
            System.out.printf("   %s%n", sortedPhones[i].toShortString());
        }
    }
}