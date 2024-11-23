import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main( String[] args ) throws InterruptedException {

        Queue<Kunde> queue = new LinkedList<>();
        Kasse kasse1 = new Kasse(queue, 1);
        Kasse kasse2 = new Kasse(queue, 2);
        kasse1.start();
        kasse2.start();


        KundenGen kundenGen1 = new KundenGen(queue);
        KundenGen kundenGen2 = new KundenGen(queue);

        kundenGen2.start();

        kundenGen1.start();


        Kasse kasse3 = new Kasse(queue, 3);

        Thread.sleep(3000);

        kasse3.start();

        Thread.sleep(9000);

        kundenGen1.interrupt();
        kundenGen2.interrupt();
        kasse1.interrupt();
        kasse2.interrupt();
        kasse3.interrupt();



    }
}