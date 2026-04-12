package learning.oop.abstraction;

/*
 * Abstraction
 *
 * Abstract classes and interfaces both define a surface (what you can call) while hiding
 * how it is done. Here, Shape hides each figure's internals while exposing area(); LogSink
 * hides where lines go while exposing emit(String). Other code can depend on those types.
 */
public final class AbstractionApp {

    private AbstractionApp() {
    }

    public static void main(String[] args) {
        Shape[] shapes = { new Rectangle(3, 4), new Circle(2) };
        for (Shape shape : shapes) {
            System.out.println(shape.getClass().getSimpleName() + " area=" + shape.area());
        }

        LogSink toConsole = new ConsoleLogSink();
        toConsole.emit("logged to stdout");

        LogSink ignored = new NoOpLogSink();
        ignored.emit("this line is not printed");
    }
}
