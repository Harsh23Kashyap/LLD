package learning.oop.interfacespractice;

/*
 * Section — this file (InterfacePracticeApp.java)
 *
 * 1) Add a private static void printWaybill(Trackable t) that prints one line:
 *      System.out.println("waybill=" + t.waybill());
 * 2) Add a private static void printGrams(Weighable w) that prints one line:
 *      System.out.println("grams=" + w.grams());
 * 3) In main, create Carton c = new Carton("WB-12", 1250);
 * 4) Call printWaybill(c); then printGrams(c); — same object, two interface views.
 *
 * Expected output (exact):
 *   waybill=WB-12
 *   grams=1250
 */
public final class InterfacePracticeApp {

    private InterfacePracticeApp() {
    }

    // TODO: printWaybill(Trackable t)
    public static void printWaybill(Trackable trackable) {
        System.out.println("Waybill: " + trackable.waybill());
    }

    // TODO: printGrams(Weighable w)
    public static void printGrams(Weighable weighable) {
        System.out.println("Grams: " + weighable.grams());
    }

    public static void main(String[] args) {
        // TODO: Carton + both print calls
        Carton carton = new Carton("WB-12", 1250);
        printWaybill(carton);
        printGrams(carton);
    }
}
