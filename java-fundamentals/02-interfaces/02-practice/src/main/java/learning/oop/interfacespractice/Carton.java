package learning.oop.interfacespractice;

/*
 * Section — this file (Carton.java)
 *
 * 1) Declare class Carton that implements Trackable and Weighable (comma-separated list).
 * 2) Add two private final fields: String for the waybill, int for grams.
 * 3) Constructor Carton(String waybill, int grams) — store both in the fields.
 * 4) Implement waybill() — return the stored waybill string.
 * 5) Implement grams() — return the stored grams value.
 * 6) Remove placeholder returns once real logic is wired.
 *
 * When InterfacePracticeApp is complete, Carton("WB-12", 1250) should report waybill WB-12
 * and grams 1250 through the two helper methods in that file.
 */
public class Carton implements Trackable, Weighable {

    // TODO fields
    private final String waybill;
    private final int grams;

    public Carton(String waybill, int grams) {
        // TODO
        this.waybill = waybill;
        this.grams = grams;
    }

    @Override
    public String waybill() {
        // TODO
        return waybill;
    }

    @Override
    public int grams() {
        // TODO
        return grams;
    }
}
