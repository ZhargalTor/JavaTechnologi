import java.util.concurrent.atomic.AtomicInteger;

public class Train implements Runnable {
    private static final AtomicInteger idCounter = new AtomicInteger(1);

    private final int id;
    private final String direction;
    private final TunnelManager manager;
    private final int maxWaitTime;
    private volatile boolean running;

    public Train(String direction, TunnelManager manager, int maxWaitTime) {
        this.id = idCounter.getAndIncrement();
        this.direction = direction;
        this.manager = manager;
        this.maxWaitTime = maxWaitTime;
        this.running = true;
    }

    public int getId() {
        return id;
    }

    public String getDirection() {
        return direction;
    }

    public void stop() {
        running = false;
    }

    @Override
    public void run() {
        System.out.printf("Поезд %d (%s) прибыл к тоннелям%n", id, direction);

        while (running) {
            Tunnel selectedTunnel = manager.selectTunnel(this);

            if (selectedTunnel == null) {
                System.out.printf("Поезд %d: все тоннели заняты, ожидание...%n", id);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
                continue;
            }

            System.out.printf("Поезд %d (%s) пытается войти в тоннель '%s'%n",
                    id, direction, selectedTunnel.getName());

            try {
                if (manager.tryEnterTunnel(this, selectedTunnel)) {
                    System.out.printf("Поезд %d (%s) ВЪЕХАЛ в тоннель '%s' (свободно: %d)%n",
                            id, direction, selectedTunnel.getName(),
                            selectedTunnel.getAvailablePermits());

                    Thread.sleep(1000 + (int)(Math.random() * 1000));

                    manager.exitTunnel(this, selectedTunnel);
                    System.out.printf("Поезд %d (%s) ВЫЕХАЛ из тоннеля '%s'%n",
                            id, direction, selectedTunnel.getName());

                    break;
                } else {
                    System.out.printf("Поезд %d (%s) не смог войти в тоннель '%s'%n",
                            id, direction, selectedTunnel.getName());
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }

        System.out.printf("Поезд %d (%s) завершил движение%n", id, direction);
    }
}