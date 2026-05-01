/*Вариант А
Разработать многопоточное приложение. Использовать возможности, пре-
доставляемые пакетом java.util.concurrent. Не использовать слово synchronized.
        Все сущности, желающие получить доступ к ресурсу, должны быть потоками.

        7. Тоннель. В горах существует два железнодорожных тоннеля, по которым
поезда могут двигаться в обоих направлениях. По обоим концам тоннеля
собралось много поездов. Обеспечить безопасное прохождение тоннелей
в обоих направлениях. Поезд можно перенаправить из одного тоннеля
в другой при превышении заданного времени ожидания на проезд.

ТОРЯШИЕВ ЖАРГАЛ Б763-2А     */



import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        System.out.println("МНОГОПОТОЧНОЕ ПРИЛОЖЕНИЕ: ЖЕЛЕЗНОДОРОЖНЫЕ ТОННЕЛИ");

        int capacity = 2;
        int maxWaitTime = 5;

        Tunnel tunnelEast = new Tunnel("Восточный", capacity);
        Tunnel tunnelWest = new Tunnel("Западный", capacity);

        TunnelManager manager = new TunnelManager(tunnelEast, tunnelWest, maxWaitTime);

        ExecutorService executor = Executors.newFixedThreadPool(10);
        List<Train> trains = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            trains.add(new Train("восточный", manager, maxWaitTime));
        }

        for (int i = 0; i < 4; i++) {
            trains.add(new Train("западный", manager, maxWaitTime));
        }

        Thread statusPrinter = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(4000);
                    manager.printStatus();
                } catch (InterruptedException e) {
                    break;
                }
            }
        });
        statusPrinter.setDaemon(true);
        statusPrinter.start();

        System.out.println("\nЗАПУСК ПОЕЗДОВ:");

        for (Train train : trains) {
            executor.submit(train);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }

        System.out.println("ВСЕ ПОЕЗДА ПРЕОДОЛЕЛИ ТОННЕЛИ");
    }
}