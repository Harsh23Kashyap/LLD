package learning.oop.practice7;

/*
 * Section 7 — this file (BundledSnack.java)
 *
 * 1) Declare two fields of type Priced (e.g. left and right) — do not duplicate sku/cents
 *    as separate strings; hold the two Priced references you are given.
 * 2) Implement constructor BundledSnack(Priced left, Priced right) — assign both fields.
 * 3) Implement cents() — return left.cents() + right.cents().
 * 4) Implement sku() — return left.sku() + "+" + right.sku() (single plus sign between skus).
 * 5) Remove the placeholder return 0 / "" once the real logic is in place.
 *
 * When Practice7App is done, wrapping Snack("B", 200) and Snack("Z", 200) should give
 * sku "B+Z" and cents 400.
 */
public class BundledSnack implements Priced {

    // TODO fields (two Priced references)
    private final Priced left;
    private final Priced right;

    public BundledSnack(Priced left, Priced right) {
        // TODO
        this.left = left;
        this.right = right;
    }

    @Override
    public int cents() {
        // TODO
        return left.cents() + right.cents();
    }

    @Override
    public String sku() {
        // TODO
        return "(" + left.sku() + "+" + right.sku() + ")";
    }
}
