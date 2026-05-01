import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class TunnelManager {
    private final Tunnel[] tunnels;
    private final ConcurrentHashMap<Train, Tunnel> trainTunnelMap;
    private final int maxWaitTime;
    private final ReentrantLock redirectLock;

    public TunnelManager(Tunnel tunnel1, Tunnel tunnel2, int maxWaitTime) {
        this.tunnels = new Tunnel[]{tunnel1, tunnel2};
        this.trainTunnelMap = new ConcurrentHashMap<>();
        this.maxWaitTime = maxWaitTime;
        this.redirectLock = new ReentrantLock();

        startWaitingMonitor();
    }

    private void startWaitingMonitor() {
        Thread monitor = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(2000);
                    checkAndRedirect();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        });
        monitor.setDaemon(true);
        monitor.start();
    }

    private void checkAndRedirect() {
        redirectLock.lock();
        try {
            for (Tunnel tunnel : tunnels) {
                tunnel.incrementWaitingTime();

                if (tunnel.getWaitingTime() >= maxWaitTime && tunnel.getWaitingCount() > 0) {
                    System.out.printf("\n⚠ ПРЕВЫШЕНИЕ ВРЕМЕНИ ОЖИДАНИЯ в тоннеле '%s' (%d сек)! Перенаправление поездов...\n",
                            tunnel.getName(), tunnel.getWaitingTime());

                    redirectTrainsFromTunnel(tunnel);
                    tunnel.resetWaitingTime();
                }
            }
        } finally {
            redirectLock.unlock();
        }
    }

    private void redirectTrainsFromTunnel(Tunnel fromTunnel) {
        Tunnel toTunnel = (fromTunnel == tunnels[0]) ? tunnels[1] : tunnels[0];

        System.out.printf("  Перенаправление поездов из тоннеля '%s' в тоннель '%s'%n",
                fromTunnel.getName(), toTunnel.getName());

        System.out.printf("  В тоннеле '%s' ожидает %d поездов%n",
                fromTunnel.getName(), fromTunnel.getWaitingCount());
    }

    public Tunnel selectTunnel(Train train) {
        redirectLock.lock();
        try {
            if (trainTunnelMap.containsKey(train)) {
                return trainTunnelMap.get(train);
            }

            String direction = train.getDirection();
            Tunnel preferred = null;

            for (Tunnel tunnel : tunnels) {
                if (tunnel.getName().toLowerCase().contains(direction.toLowerCase())) {
                    preferred = tunnel;
                    break;
                }
            }

            if (preferred != null && preferred.getAvailablePermits() > 0) {
                return preferred;
            }

            Tunnel lessBusy = tunnels[0];
            for (Tunnel tunnel : tunnels) {
                if (tunnel.getWaitingCount() < lessBusy.getWaitingCount()) {
                    lessBusy = tunnel;
                }
            }

            return lessBusy;
        } finally {
            redirectLock.unlock();
        }
    }

    public boolean tryEnterTunnel(Train train, Tunnel tunnel) throws InterruptedException {
        redirectLock.lock();
        try {
            if (trainTunnelMap.containsKey(train)) {
                return false;
            }

            if (tunnel.tryEnter()) {
                trainTunnelMap.put(train, tunnel);
                tunnel.resetWaitingTime();
                return true;
            }
            return false;
        } finally {
            redirectLock.unlock();
        }
    }

    public void exitTunnel(Train train, Tunnel tunnel) {
        redirectLock.lock();
        try {
            trainTunnelMap.remove(train);
            tunnel.exit();
        } finally {
            redirectLock.unlock();
        }
    }

    public void printStatus() {
        System.out.println("СТАТУС ТОННЕЛЕЙ:");
        for (Tunnel tunnel : tunnels) {
            System.out.printf("  Тоннель '%s' | Свободных мест: %d | Ожидает: %d | Время ожидания: %d сек%n",
                    tunnel.getName(), tunnel.getAvailablePermits(),
                    tunnel.getWaitingCount(), tunnel.getWaitingTime());
        }
    }
}