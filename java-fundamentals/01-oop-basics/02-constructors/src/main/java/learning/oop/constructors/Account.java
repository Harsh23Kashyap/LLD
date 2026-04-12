package learning.oop.constructors;

// Constructor: runs on "new"; same name as the class, no return type; gives the object its first field values.

public class Account {

    // These fields are filled in by the constructors when the object is created.
    private final String id;
    private long balanceCents;

    // No-arg constructor: for callers who have no id yet; forwards to another constructor so the real rules stay in one place.
    public Account() {
        this("UNKNOWN");
    }

    // Constructor overload: same class, different parameter list; this one forwards to the two-arg constructor so balance default (0) is defined once.
    public Account(String id) {
        this(id, 0L);
    }

    // Constructor: primary form—caller supplies id and opening balance; this is where both fields are assigned for that path.
    public Account(String id, long balanceCents) {
        this.id = id;
        this.balanceCents = balanceCents;
    }

    void describe() {
        System.out.println(id + " -> " + balanceCents + " cents");
    }
}
