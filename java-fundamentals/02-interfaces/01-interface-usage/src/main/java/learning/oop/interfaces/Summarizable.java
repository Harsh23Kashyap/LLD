package learning.oop.interfaces;

/*
 * Summarizable
 *
 * A second, independent interface. One class can implement several interfaces by listing
 * them after implements with commas. Each interface stays a small surface area instead of
 * one fat type that forces every caller to know everything.
 */
public interface Summarizable {

    String summary();
}
