import java.util.Queue;

public class Kasse extends Thread {
    private int id;
    private double saldo;

    final Queue<Kunde> kunden;

    public Kasse(Queue<Kunde> kunden, int id) {
        this.saldo = 0;
        this.kunden = kunden;
        this.id = id;
    }

    public void run(){
        while(!isInterrupted() || !kunden.isEmpty()) {
            Kunde kunde = null;
            synchronized (kunden) {
                if (!kunden.isEmpty()) {
                    kunde = kunden.poll();
                }
            }

            if (kunde != null) {
                System.out.println("Kassa: " + id + "|  Kunde: " + kunde.getId());
                try {
                    sleep((long) (Math.random() * 5000));
                } catch (InterruptedException e) {
                    interrupt();
                }

                saldo += kunde.getWert();
                System.out.println("Kassa: " + id + "|  Neuer Saldo: " + saldo + " |  Schlange: " + kunden.size());
            }
        }
    }
}
