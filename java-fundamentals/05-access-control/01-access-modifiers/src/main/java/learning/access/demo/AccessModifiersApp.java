package learning.access.demo;

/*
 * AccessModifiersApp
 *
 * public — this class is visible everywhere the module/classpath exposes it; main is the
 * usual entry point.
 *
 * The main method below ties the other types together: Wallet shows private + public API,
 * Friend shows package-private cooperation, JuniorVault shows protected visibility through
 * inheritance.
 */
public final class AccessModifiersApp {

    private AccessModifiersApp() {
    }

    public static void main(String[] args) {
        Wallet wallet = new Wallet();
        wallet.deposit(200);
        System.out.println("balance after deposit: " + wallet.balance());

        Friend.tweak(wallet);
        System.out.println("balance after same-package tweak: " + wallet.balance());

        JuniorVault vault = new JuniorVault();
        System.out.println("junior vault code: " + vault.peekCode());
    }
}
