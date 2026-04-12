package learning.access.demo;

/*
 * JuniorVault
 *
 * Subclass of Vault in the same package. It reads the protected field code from the
 * superclass inside its own methods. That access is allowed because subclass code can see
 * protected members of its supertype (rules are slightly stricter across packages, but this
 * same-package subclass case is the common learning path).
 */
public class JuniorVault extends Vault {

    public JuniorVault() {
        super(99);
    }

    public int peekCode() {
        return code;
    }
}
