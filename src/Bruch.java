public class Bruch {
    private final long zähler;
    private final long nenner;

    public Bruch() {
        this(1, 1);
    }

    // als Hausaufgabe
    public Bruch(double zahl) {
        // TODO
        // wie geht das?
        this( (int)zahl, 1); // nicht korrekt, nur damit die IDE nicht jammert ...
    }

    public Bruch(long zähler, long nenner) {
        this.zähler = zähler;
        this.nenner = nenner;
    }

    public Bruch add(Bruch b) {
        long neuerZähler = this.zähler * b.nenner + b.zähler * this.nenner;
        long neuerNenner = this.nenner * b.nenner;
        return new Bruch(neuerZähler, neuerNenner).kürze();
    }

    public Bruch sub(Bruch b) {
        return this.add( b.negiere() ).kürze();
    }

    public Bruch mult(Bruch b) {
        return new Bruch( this.zähler * b.zähler, this.nenner * b.nenner ).kürze();
    }

    public Bruch div(Bruch b) {
        return this.mult( b.kehrWert() ).kürze();
    }

    public Bruch kürze() {
        long teiler = ggT(zähler, nenner);
        return new Bruch(zähler / teiler, nenner / teiler);
    }

    public Bruch negiere() {
        return new Bruch(-zähler, nenner);
    }

    public Bruch kehrWert() {
        return new Bruch(nenner, zähler);
    }

    public boolean isEqual(Bruch b) {
        // Möglichkeit 1: mathematische Lösung
//        Bruch c = this.div(b);
//        return (c.zähler == c.nenner);

        // Möglichkeit 2: triviale Lösung
        Bruch a = this.kürze();
        b = b.kürze();
        return (a.zähler == b.zähler && a.nenner == b.nenner);
    }

    public String toString() {
        return zähler + "/" + nenner;
    }

    public static Bruch addiere(Bruch b1, Bruch b2) {
        return b1.add(b2);
    }

    private long ggT(long a, long b) {
        // sanity check
        if (a == 0) return b;
        if (b == 0) return a;
        // mit negativen Zahlen klappt auch nicht
        a = Math.abs(a);    // oder: if (a < 0) a = -a;
        b = Math.abs(b);    //       if (b < 0) b = -b;

        // uralter Algorithmus von Euklid
        while (a != b) {
            if (a > b) a -= b;
            else b -= a;
        }
        return a;
    }
}
