package learning.oop.abstraction;

/*
 * Concrete subclass of Shape. area() is implemented here; the compiler enforces that
 * obligation because the superclass left area() abstract.
 */
public class Rectangle extends Shape {

    private final double width;
    private final double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }
}
