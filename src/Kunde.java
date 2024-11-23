import java.util.Random;

public class Kunde {
    private int id ;
    private double warenwert;
    private static int Kundennummer = 0;

    private Kunde( int id, double warenwert ) {
        this.id = id;
        this.warenwert = warenwert;
    }

    public static Kunde einkaufen(){
        int id = ++Kundennummer;
        double wert = getWarenwert();
        Kunde kunde = new Kunde(id, wert);

        System.out.println("Kunde: " + id  +  " |  Wert: " + wert);

        return kunde;
    }

    private static double getWarenwert(){
        return Math.random() * 100;
    }

    public double getWert(){
        return warenwert;
    }

    public int getId() {
        return id;
    }
}
