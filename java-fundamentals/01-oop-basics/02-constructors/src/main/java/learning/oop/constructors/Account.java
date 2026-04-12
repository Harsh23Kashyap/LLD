package learning.oop.constructors;

/*
 * Constructors
 *
 * A constructor runs when you use new with this class. It has the same name as the class
 * and no return type (not even void). Its job is to leave the object in a sensible initial
 * state (fields set, not half-initialized).
 *
 * You may define more than one constructor as long as the parameter lists differ. That is
 * constructor overloading. Calling this(...) from one constructor runs another constructor
 * on the same object first, so shared setup (like default balance) lives in one place.
 *
 * If you write any constructor at all, Java will not inject a default no-argument constructor.
 * The no-argument Account() below is written by hand, not supplied by the compiler.
 */
public class Account {

    // These fields are filled in by the constructors when the object is created.
    private final String id;
    private long balanceCents;

    public Account() {
        this("UNKNOWN");
    }

    public Account(String id) {
        this(id, 0L);
    }

    public Account(String id, long balanceCents) {
        this.id = id;
        this.balanceCents = balanceCents;
    }

    void describe() {
        System.out.println(id + " -> " + balanceCents + " cents");
    }
}
