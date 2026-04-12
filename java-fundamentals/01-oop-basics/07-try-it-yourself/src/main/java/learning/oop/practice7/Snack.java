package learning.oop.practice7;

/*
 * Section 7 — this file (Snack.java)
 *
 * 1) Declare fields to remember the sku string and the cents value passed in at construction.
 * 2) Implement constructor Snack(String sku, int cents) — store both in those fields.
 * 3) Implement cents() — return the stored cents.
 * 4) Implement sku() — return the stored sku.
 * 5) Remove the placeholder return 0 / "" once the real logic is in place.
 *
 * When Practice7App is done, a Snack("A", 150) should contribute sku "A" and cents 150.
 */
public class Snack implements Priced {

    // TODO fields
    private final String sku;
    private final int cents;

    public Snack(String sku, int cents) {
        // TODO
        this.sku = sku;
        this.cents = cents;
    }

    @Override
    public int cents() {
        // TODO
        return cents;
    }

    @Override
    public String sku() {
        // TODO
        return sku;
    }
}
