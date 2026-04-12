package learning.oop.encapsulation;

<<<<<<< HEAD
// Encapsulation: you use Person only through its methods; its fields are not part of the public surface.

=======
/*
 * This class only talks to Person through its public methods (constructor, setters,
 * printSummary). Assigning to p.name or p.ageYears from here would not compile because
 * those fields are private. A negative age in new Person(..., -20) would fail inside
 * setAgeYears during construction.
 */
>>>>>>> 1cfe337 (──────────────────────────────)
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
    }
}
