package learning.oop.inheritance;

/*
 * Base class (superclass)
 *
 * Shared state and behavior for a family of types live here. More specific types can
 * declare "extends Vehicle" to inherit what is visible from this class and then add or
 * replace behavior. Private fields stay inside Vehicle; subclasses use public methods
 * (or protected members, if you add them) to reuse that logic.
 */
public class Vehicle {

    private final String make;
    private final int year;

    public Vehicle(String make, int year) {
        this.make = make;
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public int getYear() {
        return year;
    }

    public void printSummary() {
        System.out.println(getMake() + " (" + getYear() + ")");
    }
}
