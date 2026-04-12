package learning.oop.basics;

/**
 * A class groups state (fields) and behavior (methods) for one kind of thing.
 * An object is a concrete instance; you make one with new Book(...).
 */
public class Book {

    // Instance fields: every Book object has its own values here.
    String title;
    String author;
    int pageCount;

    /**
     * Runs when you call new Book(...). Copies the arguments into this object.
     */
    public Book(String title, String author, int pageCount) {
        this.title = title;
        this.author = author;
        this.pageCount = pageCount;
    }

    /** Prints title, author, and page count on one line. */
    public void describe() {
        System.out.println(title + " by " + author + " (" + pageCount + " pages)");
    }
}
