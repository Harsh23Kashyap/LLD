package learning.oop.interfaces;

/*
 * Identifiable
 *
 * An interface lists method signatures without bodies. A class picks up this contract with
 * "implements Identifiable" and supplies id(). Callers can depend on Identifiable alone when
 * they only need an id and do not care which concrete class sits behind it.
 */
public interface Identifiable {

    String id();
}
