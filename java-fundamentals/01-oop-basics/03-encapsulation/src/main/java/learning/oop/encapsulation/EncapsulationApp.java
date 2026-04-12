package learning.oop.encapsulation;

// Encapsulation: you use Person only through its methods; its fields are not part of the public surface.

public final class EncapsulationApp {

    private EncapsulationApp() {
    }

    public static void main(String[] args) {
        // From here you only use Person's public methods; private fields are not accessible.
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
