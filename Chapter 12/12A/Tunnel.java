import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class Tunnel {
    private final String name;
    private final Semaphore semaphore;
    private final AtomicInteger waitingTrains;
    private final AtomicInteger waitingTime;

    public Tunnel(String name, int capacity) {
        this.name = name;
        this.semaphore = new Semaphore(capacity, true);
        this.waitingTrains = new AtomicInteger(0);
        this.waitingTime = new AtomicInteger(0);
    }

    public String getName() {
        return name;
    }

    public boolean tryEnter() {
        waitingTrains.incrementAndGet();
        boolean entered = semaphore.tryAcquire();
        if (entered) {
            waitingTrains.decrementAndGet();
        }
        return entered;
    }

    public void enter() throws InterruptedException {
        waitingTrains.incrementAndGet();
        semaphore.acquire();
        waitingTrains.decrementAndGet();
    }

    public void exit() {
        semaphore.release();
    }

    public int getWaitingCount() {
        return waitingTrains.get();
    }

    public void incrementWaitingTime() {
        waitingTime.incrementAndGet();
    }

    public int getWaitingTime() {
        return waitingTime.get();
    }

    public void resetWaitingTime() {
        waitingTime.set(0);
    }

    public int getAvailablePermits() {
        return semaphore.availablePermits();
    }
}