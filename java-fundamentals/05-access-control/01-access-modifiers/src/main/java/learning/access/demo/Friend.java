package learning.access.demo;

/*
 * Friend
 *
 * Same package as Wallet, so this type can call Wallet’s package-private method
 * adjustSamePackageOnly. That would not compile from a different package even if the method
 * were visible on a public class—package scope is about the package, not only the type’s name.
 *
 * This class itself is package-private (no public modifier), which is fine for helpers that
 * are not meant to be used outside this package.
 */
class Friend {

    static void tweak(Wallet wallet) {
        wallet.adjustSamePackageOnly(-50);
    }
}
