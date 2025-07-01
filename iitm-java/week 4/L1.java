/* Summary Lecture on Abstract Classes and Interfaces in Java

* Class Hierarchy:
    -Organizes related classes under a common parent (e.g., Shape as a parent for Circle, Square, Rectangle).
    -Enables grouping objects of different types into collections (e.g., Shape[] holding various shapes) using subtyping.
* Abstract Classes:
Used to define a template with common behavior for subclasses, ensuring specific methods are implemented.
Abstract Methods: Declared without a body (e.g., abstract double perimeter();), forcing subclasses to provide concrete implementations.
Rule: If a class contains at least one abstract method, it must be declared abstract. Abstract classes cannot be instantiated (e.g., new Shape() is invalid).
Usage: Allows variables/arrays of the abstract type (e.g., Shape[] shapes) to hold concrete subclass objects (Circle, Square), leveraging dynamic dispatch to call the correct method (e.g., shapes[i].perimeter()).
Example: Shape defines abstract double perimeter();, ensuring Circle (2πr), Square (4s), and Rectangle (2(l+w)) implement it differently.
* Interfaces:
    -A special type of abstract class with only abstract methods (no concrete implementations), defining a contract of capabilities.
    -Purpose: Allows multiple inheritance of behavior specifications without implementation conflicts, unlike classes (Java prohibits multiple class inheritance).
    -Syntax: Declared with interface (e.g., interface Comparable { int cmp(Object o); }). Classes use implements to provide concrete implementations.
    -Example: Comparable interface with cmp method enables sorting. A class like Circle can implement Comparable to define comparison logic (e.g., based on radius).
    -Multiple Interfaces: A class can implement multiple interfaces (e.g., class Circle extends Shape implements Comparable, Drawable), but extend only one class.
* Abstract Classes vs. Interfaces:
    -Abstract Classes: Can have both abstract and concrete methods, provide partial implementation, and support single inheritance.
* Interfaces:
    -Contain only abstract methods (or default methods in Java 8+), ensure no implementation conflicts, and support multiple inheritance.
* Why Interfaces?:
    -Avoid conflicts in multiple inheritance (e.g., two parent classes with different implementations of a method). Interfaces provide signatures only, requiring the subclass to implement them.
* Dynamic Dispatch:
    -Ensures the correct method (from the concrete subclass) is called at runtime, even when using an abstract class or interface type.
    -Example: Shape s = new Circle(); s.perimeter() calls Circle’s perimeter method; Comparable c = new MyClass(); c.cmp(o) calls MyClass’s cmp.
* Practical Example:
    -Shape abstract class enforces perimeter implementation for all shapes.
    -Comparable interface enforces cmp for sorting, allowing quicksort to work on any array of Comparable objects.
    -A class like Circle can extend Shape (for shape properties) and implement Comparable (for sorting), combining multiple capabilities safely.
* Takeaway:
    -Abstract classes enforce method implementation and provide partial implementations, useful for shared behavior in a hierarchy.
    -Interfaces define pure contracts, enabling multiple capabilities without implementation conflicts.
    -Together, they enhance Java’s class hierarchy, ensuring disciplined programming and flexible, type-safe collections. 
*/

// This program demonstrates abstract classes and interfaces using a Shape hierarchy  and a Comparable interface for sorting shapes by perimeter.

// Interface defining a comparison capability
interface Comparable {
    // Abstract method to compare this object with another
    // Returns -1 if this < o, 0 if equal, 1 if this > o
    int cmp(Object o);
}

// Abstract class defining a Shape with a mandatory perimeter method
abstract class Shape {
    // Abstract method for perimeter, to be implemented by subclasses
    abstract double perimeter();

    // Concrete method (example of shared behavior in abstract class)
    public String getType() {
        return this.getClass().getSimpleName();
    }
}

// Circle class extending Shape and implementing Comparable
class Circle extends Shape implements Comparable {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    // Implement perimeter from Shape
    @Override
    public double perimeter() {
        return 2 * Math.PI * radius; // 2πr
    }

    // Implement cmp from Comparable for sorting by perimeter
    @Override
    public int cmp(Object o) {
        if (!(o instanceof Circle)) {
            throw new IllegalArgumentException("Can only compare with Circle");
        }
        Circle other = (Circle) o;
        double diff = this.perimeter() - other.perimeter();
        return diff < 0 ? -1 : (diff == 0 ? 0 : 1);
    }
}

// Square class extending Shape and implementing Comparable
class Square extends Shape implements Comparable {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    // Implement perimeter from Shape
    @Override
    public double perimeter() {
        return 4 * side; // 4s
    }

    // Implement cmp from Comparable for sorting by perimeter
    @Override
    public int cmp(Object o) {
        if (!(o instanceof Square)) {
            throw new IllegalArgumentException("Can only compare with Square");
        }
        Square other = (Square) o;
        double diff = this.perimeter() - other.perimeter();
        return diff < 0 ? -1 : (diff == 0 ? 0 : 1);
    }
}

// Rectangle class extending Shape and implementing Comparable
class Rectangle extends Shape implements Comparable {
    private double length, width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    // Implement perimeter from Shape
    @Override
    public double perimeter() {
        return 2 * (length + width); // 2(l+w)
    }

    // Implement cmp from Comparable for sorting by perimeter
    @Override
    public int cmp(Object o) {
        if (!(o instanceof Rectangle)) {
            throw new IllegalArgumentException("Can only compare with Rectangle");
        }
        Rectangle other = (Rectangle) o;
        double diff = this.perimeter() - other.perimeter();
        return diff < 0 ? -1 : (diff == 0 ? 0 : 1);
    }
}

// Utility class with static quicksort for Comparable objects
class SortUtil {
    // Static method to sort an array of Comparable objects
    public static void quicksort(Comparable[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quicksort(arr, low, pi - 1);
            quicksort(arr, pi + 1, high);
        }
    }

    private static int partition(Comparable[] arr, int low, int high) {
        Comparable pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j].cmp(pivot) <= 0) {
                i++;
                Comparable temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        Comparable temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}

// Main class to demonstrate abstract classes and interfaces
public class AbstractInterfaceDemo {
    public static void main(String[] args) {
        // Create an array of Shapes (abstract class type)
        Shape[] shapes = {
            new Circle(5.0),      // Perimeter: 2π*5 ≈ 31.42
            new Square(4.0),      // Perimeter: 4*4 = 16
            new Rectangle(3.0, 4.0) // Perimeter: 2*(3+4) = 14
        };

        // Demonstrate dynamic dispatch with abstract class
        System.out.println("Perimeters of shapes:");
        for (Shape s : shapes) {
            System.out.printf("%s perimeter: %.2f%n", s.getType(), s.perimeter());
        }

        // Demonstrate sorting using Comparable interface
        // Note: Sorting assumes all shapes are of the same type for simplicity
        Comparable[] circles = {
            new Circle(3.0), // Perimeter: 2π*3 ≈ 18.85
            new Circle(5.0), // Perimeter: 2π*5 ≈ 31.42
            new Circle(2.0)  // Perimeter: 2π*2 ≈ 12.57
        };

        System.out.println("\nSorting circles by perimeter:");
        SortUtil.quicksort(circles, 0, circles.length - 1);
        for (Comparable c : circles) {
            Circle circle = (Circle) c;
            System.out.printf("Circle perimeter: %.2f%n", circle.perimeter());
        }
    }
}