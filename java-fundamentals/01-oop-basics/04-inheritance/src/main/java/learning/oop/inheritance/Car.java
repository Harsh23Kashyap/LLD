package learning.oop.inheritance;

/*
 * Subclass (derived class)
 *
 * "extends Vehicle" means Car is a Vehicle: it inherits the public API of Vehicle and
 * may add fields and methods. The subclass constructor must invoke a superclass constructor
 * first; super(make, year) passes the shared arguments up the chain. printSummary is
 * overridden so a Car prints its own details while still using getMake() and getYear().
 */
public class Car extends Vehicle {

    private final int doors;

    public Car(String make, int year, int doors) {
        super(make, year);
        this.doors = doors;
    }

    @Override
    public void printSummary() {
        //Way 1
        // super.printSummary();
        // System.out.println(", doors " + doors);

        //Way 2
        System.out.println(getMake() + " (" + getYear() + "), doors " + doors);
    }
}
