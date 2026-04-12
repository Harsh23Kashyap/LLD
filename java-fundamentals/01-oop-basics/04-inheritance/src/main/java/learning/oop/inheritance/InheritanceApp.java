package learning.oop.inheritance;

/*
 * A variable typed as Vehicle can refer to a Car because a Car is a Vehicle. Calling
 * printSummary on that variable still dispatches to the implementation defined on the
 * actual object (Car), not the reference type alone.
 */
public final class InheritanceApp {

    private InheritanceApp() {
    }

    public static void main(String[] args) {
        Vehicle plain = new Vehicle("Acme", 2010);
        Car sedan = new Car("Acme", 2022, 4);

        plain.printSummary();
        sedan.printSummary();

        Vehicle asVehicle = sedan;
        asVehicle.printSummary();
    }
}
