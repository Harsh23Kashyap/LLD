package learning.oop.encapsulation;

/** Reads and updates state only through Person's methods, not by touching fields. */
public final class EncapsulationApp {

    private EncapsulationApp() {
    }
    public static void main(String[] args) {
        Person p = new Person("Asha", 28);
        p.printSummary();

        p.setName("Asha Rao");
        p.setAgeYears(29);
        p.printSummary();

        // This would throw an exception:
        // Person p2 = new Person("John Doe", -20);
        // p2.printSummary();
        // System.out.println();
    }
}
