package learning.access.demo;

/*
 * Vault
 *
 * protected — the code field is visible inside this class, in subclasses (even later in
 * other packages when inheritance applies), and in the same package. Typical use: extension
 * points for subclasses without exposing the field as public API on every instance.
 */
public class Vault {

    protected int code;

    public Vault(int code) {
        this.code = code;
    }
}
