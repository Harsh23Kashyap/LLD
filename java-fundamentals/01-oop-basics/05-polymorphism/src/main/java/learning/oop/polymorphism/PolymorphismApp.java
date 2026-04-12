package learning.oop.polymorphism;

/*
 * Polymorphism (instance methods)
 *
 * The array is typed as MediaItem[], but elements may be Song, Podcast, or MediaItem.
 * Calling play() on each element runs the overriding method for that object's real class,
 * including the base implementation for the plain MediaItem entry.
 */
public final class PolymorphismApp {

    private PolymorphismApp() {
    }

    public static void main(String[] args) {
        MediaItem[] queue = {
            new Song("Maps", "Yeah Yeah Yeahs"),
            new Podcast("Stuff You Should Know", 900),
            new MediaItem("Chime")
        };

        for (MediaItem item : queue) {
            item.play();
        }
    }
}
