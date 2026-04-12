package learning.oop.polymorphism;

/*
 * Base type for a small media hierarchy. Subclasses override play() with their own output.
 * This class is concrete so the example does not rely on abstract methods (those come later).
 */
public class MediaItem {

    private final String title;

    public MediaItem(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void play() {
        System.out.println(title + ": generic tone");
    }
}
