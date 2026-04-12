package learning.oop.basics;

/** Same class (Book), several objects: same layout, different field values. */
public final class ClassesAndObjectsApp {

    // private ClassesAndObjectsApp() {
    //     // main is static; nothing should new this class.
    // }

    public static void main(String[] args) {
        // Book = type. cleanCode = variable. new Book(...) = one object in memory.
        Book cleanCode = new Book("Clean Code", "Robert C. Martin", 464);

        // Second object: its fields are independent of cleanCode.
        Book effectiveJava = new Book("Effective Java", "Joshua Bloch", 416);

        System.out.println("Two objects, one class:");
        cleanCode.describe();
        effectiveJava.describe();

        // Reassign: cleanCode points at a different object now.
        cleanCode = new Book("Refactoring", "Martin Fowler", 448);
        System.out.println();
        System.out.println("After reassigning cleanCode to a different book:");
        cleanCode.describe();
    }
}
