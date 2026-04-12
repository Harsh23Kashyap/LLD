package learning.oop.practice7;

/*
 * Section 7 — this file (Priced.java)
 *
 * In this file you only maintain the contract for anything that can report a price.
 *
 * 1) Keep this as an interface named Priced.
 * 2) Declare int cents(); — price in whole cents.
 * 3) Declare String sku(); — short id / stock code for the line item.
 *
 * Do not add method bodies here (interfaces only declare signatures). Implementations are
 * Snack.java and BundledSnack.java.
 */
public interface Priced {

    int cents();

    String sku();
}
