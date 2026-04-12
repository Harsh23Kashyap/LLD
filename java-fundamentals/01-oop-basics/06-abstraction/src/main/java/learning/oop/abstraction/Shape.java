package learning.oop.abstraction;

/*
 * Abstract class
 *
 * Marked abstract: you cannot instantiate it with new Shape(...). It can declare abstract
 * methods without bodies; every concrete subclass must implement them (or stay abstract).
 * It can also contain normal fields and concrete methods shared by subclasses.
 */
public abstract class Shape {

    public abstract double area();
}
