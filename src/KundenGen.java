import java.util.Queue;

public class KundenGen extends Thread {

    private final Queue<Kunde> kunden;

    public KundenGen(Queue<Kunde> kunden) {
        this.kunden = kunden;
    }

    public void run() {

        while (!interrupted()) {
            Kunde neuerKunde = Kunde.einkaufen();

            try {
                sleep(getRandomDelay());
            } catch (InterruptedException e) {
                interrupt();
                break;
            }

            synchronized (kunden) {
                kunden.offer(neuerKunde);
                System.out.println("Kunde: " + neuerKunde.getId() + " in Queue");
                // kunden.notifyAll();
            }
        }
    }

    private static long getRandomDelay(){
        return (long) (Math.random()  * 1000) + 1000;
    }
}
