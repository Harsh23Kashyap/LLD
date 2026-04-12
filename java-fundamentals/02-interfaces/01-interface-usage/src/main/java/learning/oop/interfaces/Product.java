package learning.oop.interfaces;

/*
 * Product
 *
 * This class implements both Identifiable and Summarizable. The compiler checks that every
 * required method from each interface exists with a compatible signature. The same Product
 * instance can be passed to a method that takes Identifiable, or to one that takes Summarizable.
 */
public class Product implements Identifiable, Summarizable {

    private final String id;
    private final String title;
    private final int priceCents;

    public Product(String id, String title, int priceCents) {
        this.id = id;
        this.title = title;
        this.priceCents = priceCents;
    }

    @Override
    // If you don't use the @Override annotation, the compiler will not check if the method is actually overriding a method from the interface.
    public String id() {
        return id;
    }

    @Override
    public String summary() {
        return title + " @ " + priceCents + " cents";
    }
}
