package learning.access.demo;

/*
 * Wallet
 *
 * private — the cents field is only visible inside this class. Outside code must use the
 * public methods you expose (deposit, balance) instead of touching cents directly.
 *
 * package-private (no keyword) — adjustSamePackageOnly can be called from any class in the
 * same package (see Friend.java). It is not part of the public API for other packages.
 */
public class Wallet {

    private int cents;

    public void deposit(int amount) {
        cents += amount;
    }

    public int balance() {
        return cents;
    }

    void adjustSamePackageOnly(int delta) {
        cents += delta;
    }
}
