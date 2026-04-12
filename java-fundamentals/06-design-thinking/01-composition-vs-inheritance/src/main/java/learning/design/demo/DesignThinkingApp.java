package learning.design.demo;

/*
 * DesignThinkingApp
 *
 * Ties the story together: build an Engine, inject it into a Car, call startDrive. The same
 * Car is still a Vehicle reference if you assign it upward—inheritance gives you that shared
 * abstraction; composition gives you modular parts under the hood.
 */
public final class DesignThinkingApp {

    private DesignThinkingApp() {
    }

    public static void main(String[] args) {
        Engine v6 = new Engine(300);
        Car sedan = new Car(v6);
        sedan.startDrive();

        Vehicle asVehicle = sedan;
        System.out.println("still a Vehicle:");
        asVehicle.move();
    }
}
