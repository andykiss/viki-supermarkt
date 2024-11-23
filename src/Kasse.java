import java.util.LinkedList;
import java.util.Queue;

public class Kasse extends Thread {
    private int id;
    private double saldo;

    Queue<Kunde> kunden;

    public Kasse(Queue<Kunde> kunden, int id) {
        this.saldo = 0;
        this.kunden = kunden;
        this.id = id;
    }

    public void run(){
        Kunde kunde = null;
        while(!kunden.isEmpty() || !Thread.currentThread().isInterrupted()){
            synchronized (this) {
                if(!kunden.isEmpty()){
                    kunde = kunden.poll();
                    saldo += kunde.getWert();

                    try {
                        sleep(5000);
                    } catch (InterruptedException e) {

                    }

                    System.out.println("Kassa: " + id + "|  Neuer Saldo: " + saldo + " |  Schlange: " + kunden.size());
                } else  {
                    try {
                        sleep(100);
                        continue;
                    } catch (InterruptedException e) {
                       continue;
                    }
                }
            }


        }
    }
}
