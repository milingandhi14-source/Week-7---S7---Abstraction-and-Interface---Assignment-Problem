abstract class Shape {
    private static int counter = 0;
    private final String shapeId;

    Shape() {
        shapeId = "S-" + (++counter);
    }

    public abstract double calculateArea();

    void scale(double factor) {
    }

    void scale(double xFactor, double yFactor) {
        scale(xFactor);
        scale(yFactor);
    }

    String getShapeId() {
        return shapeId;
    }

    static void printArea(Shape s) {
        System.out.println(s.calculateArea());
    }
}

class CircleShape extends Shape {
    private double radius;

    public CircleShape(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    void scale(double factor) {
        radius *= factor;
    }

    @Override
    void scale(double xFactor, double yFactor) {
        radius *= xFactor;
    }
}

class SquareShape extends Shape {
    private double side;

    public SquareShape(double side) {
        this.side = side;
    }

    @Override
    public double calculateArea() {
        return side * side;
    }

    @Override
    void scale(double factor) {
        side *= factor;
    }

    @Override
    void scale(double xFactor, double yFactor) {
        side *= xFactor;
    }
}

public class Problem1 {
    public static void main(String[] args) {
        CircleShape c = new CircleShape(5.0);
        System.out.println(c.calculateArea());

        SquareShape sq = new SquareShape(4.0);
        System.out.println(sq.calculateArea());

        sq.scale(2.0);
        System.out.println(sq.calculateArea());

        Shape.printArea(c);
    }
}