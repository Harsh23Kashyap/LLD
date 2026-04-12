package learning.oop.abstraction;

/*
 * Another concrete Shape. Different fields and formula, same abstract contract (area).
 */
public class Circle extends Shape {

    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}
