abstract class Shape {

    int num1;
    int num2;

    Shape(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    abstract void printArea();
}

class Rectangle extends Shape {

    Rectangle(int length, int breadth) {
        super(length, breadth);
    }

    void printArea() {
        int area = num1 * num2;
        System.out.println("Area of Rectangle = " + area);
    }
}

class Triangle extends Shape {

    Triangle(int base, int height) {
        super(base, height);
    }

    void printArea() {
        double area = 0.5 * num1 * num2;
        System.out.println("Area of Triangle = " + area);
    }
}

class Circle extends Shape {

    Circle(int radius) {
        super(radius, 0);
    }

    void printArea() {
        double area = Math.PI * num1 * num1;
        System.out.println("Area of Circle = " + area);
    }
}

public class Program9 {

    public static void main(String[] args) {

        Rectangle rectangle = new Rectangle(10, 5);
        Triangle triangle = new Triangle(10, 8);
        Circle circle = new Circle(7);

        rectangle.printArea();
        triangle.printArea();
        circle.printArea();
    }
}