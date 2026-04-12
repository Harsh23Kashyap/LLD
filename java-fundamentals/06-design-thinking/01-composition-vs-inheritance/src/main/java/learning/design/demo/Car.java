package learning.design.demo;

/*
 * Car
 *
 * IS-A: extends Vehicle — a car is a vehicle, so it inherits move().
 *
 * HAS-A: private final Engine engine — the car owns an engine reference. That is composition:
 * the engine can be swapped in tests, shared concepts stay in Engine, and Car orchestrates
 * parts instead of pretending to be an engine itself.
 */
public class Car extends Vehicle {

    private final Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
    }

    public void startDrive() {
        engine.start();
        move();
    }
}
