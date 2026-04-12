package learning.oop.constructors;

/**
 * Constructors run after "new" and set up the object's starting state.
 * Several constructors can exist; one can call another with this(...).
 */
public class Account {

    private final String id;
    private long balanceCents;

    // No-arg constructor.
    public Account() {
        this("UNKNOWN");
    }

    // Starts balance at 0; forwards to Account(id, 0) so setup is not duplicated.
    public Account(String id) {
        // this(id, 0L); or use and call this constructor inside this constructor.
        this.id = id;
        this.balanceCents = 0L;
    }

    // Full form: caller supplies id and opening balance.
    public Account(String id, long balanceCents) {
        this.id = id;
        this.balanceCents = balanceCents;
    }

    void describe() {
        System.out.println(id + " -> " + balanceCents + " cents");
    }
}
