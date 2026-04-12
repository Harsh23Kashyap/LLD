package learning.oop.polymorphism;

/*
 * Another subclass with its own play() body. At runtime the JVM selects the implementation
 * attached to the actual object, not only the MediaItem type written on the variable.
 */
public class Podcast extends MediaItem {

    private final int episode;

    public Podcast(String title, int episode) {
        super(title);
        this.episode = episode;
    }

    @Override
    public void play() {
        System.out.println(getTitle() + " episode " + episode + " (speech)");
    }
}
