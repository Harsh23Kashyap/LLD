package learning.oop.polymorphism;

/*
 * Subclass of MediaItem. play() has the same name, return type, and compatible parameters
 * as MediaItem.play, so it overrides. The @Override annotation asks the compiler to check that.
 */
public class Song extends MediaItem {

    private final String artist;

    public Song(String title, String artist) {
        super(title);
        this.artist = artist;
    }

    @Override
    public void play() {
        System.out.println(getTitle() + " by " + artist + " (music)");
    }
}
