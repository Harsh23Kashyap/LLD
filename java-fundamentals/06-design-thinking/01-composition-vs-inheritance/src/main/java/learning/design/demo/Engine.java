package learning.design.demo;

/*
 * Engine
 *
 * A separate type you can reuse. It is not a kind of vehicle; it is a part you bolt into a
 * vehicle through a field (composition / HAS-A). Car code delegates to Engine instead of
 * duplicating motor logic inside every vehicle class.
 */
public class Engine {

    private final int horsepower;

    public Engine(int horsepower) {
        this.horsepower = horsepower;
    }

    public void start() {
        System.out.println("engine start (" + horsepower + " hp)");
    }
}
