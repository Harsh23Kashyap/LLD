package learning.oop.constructors;

/**
 * Two ways to construct the same class: one-arg vs two-arg constructor.
 * If you define any constructor, Java does not inject a no-arg default for you.
 */
public final class ConstructorsApp {

    private ConstructorsApp() {
    }

    public static void main(String[] args) {
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
