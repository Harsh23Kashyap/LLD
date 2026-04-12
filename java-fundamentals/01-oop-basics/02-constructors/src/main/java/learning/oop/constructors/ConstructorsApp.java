package learning.oop.constructors;

// Each "new Account(...)" picks the constructor whose parameters match; that sets how the object starts out.

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
