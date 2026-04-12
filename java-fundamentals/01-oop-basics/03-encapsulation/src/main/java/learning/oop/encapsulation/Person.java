package learning.oop.encapsulation;

// Encapsulation: hide how data is stored and only allow changes through this class's methods, so rules stay in one place.

public class Person {

    // Encapsulation here: these fields are not visible outside; other code must use getters/setters instead of reading or assigning them directly.
    private String name;
    private int ageYears;

    // Encapsulation in the constructor: set up state through the same controlled paths (e.g. setAgeYears) so a new object cannot skip your checks.
    public Person(String name, int ageYears) {
        this.name = name;
        setAgeYears(ageYears);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAgeYears() {
        return ageYears;
    }

    public void setAgeYears(int ageYears) {
        if (ageYears < 0) {
            throw new IllegalArgumentException("age cannot be negative");
        }
        this.ageYears = ageYears;
    }

    void printSummary() {
        System.out.println(name + ", age " + ageYears);
    }
}
