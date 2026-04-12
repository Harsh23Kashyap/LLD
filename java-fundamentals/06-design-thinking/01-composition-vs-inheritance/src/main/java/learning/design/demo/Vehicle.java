package learning.design.demo;

/*
 * Vehicle
 *
 * Base type for things that move on the road. Subclasses use "extends" to model IS-A: a car
 * is a vehicle, so Car extends Vehicle and inherits move(). Shared behavior that truly belongs
 * on every vehicle stays here; specialized behavior stays in subclasses.
 */
public class Vehicle {

    public void move() {
        System.out.println("vehicle rolling");
    }
}
