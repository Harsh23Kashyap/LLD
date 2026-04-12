package learning.oop.interfacespractice;

/*
 * Section — this file (Trackable.java)
 *
 * 1) Keep this as an interface named Trackable.
 * 2) Declare exactly one method: String waybill(); (a shipping label or tracking id).
 *
 * No method bodies on an interface (unless you later add default methods, which this exercise
 * does not use). Implementations live in Carton.java.
 */
public interface Trackable {

    String waybill();
}
