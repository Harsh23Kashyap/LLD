package learning.oop.encapsulation;

/**
 * Fields are private so other classes cannot change them directly.
 * Access goes through methods (getters / setters), where you can validate or adjust behavior later.
 */
public class Person {

    private String name;
    private int ageYears;

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
