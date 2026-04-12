package learning.oop.constructors;

<<<<<<< HEAD
// Each "new Account(...)" picks the constructor whose parameters match; that sets how the object starts out.

=======
/*
 * The three new Account(...) calls below differ only by their arguments. The compiler
 * chooses which constructor runs: none, (String id), or (String id, long balanceCents).
 * Same type, three entry points into construction.
 */
>>>>>>> 1cfe337 (──────────────────────────────)
public final class ConstructorsApp {

    private ConstructorsApp() {
    }

    public static void main(String[] args) {
        // Different argument lists below mean different constructors run, but they all produce a valid Account.
        Account unknown = new Account();
        Account empty = new Account("CHK-1001");
        Account funded = new Account("SAV-2002", 50_000L);
        unknown.describe();
        System.out.println();
        empty.describe();
        System.out.println();
        funded.describe();
        System.out.println();
    }
}
