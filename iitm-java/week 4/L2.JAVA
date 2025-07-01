/* Summary of Lecture on Interfaces in Java

 *Interfaces Overview:
    -Interfaces are purely abstract entities, containing only abstract methods (no implementations) and no instance variables, preventing instantiation.
    -Classes use implements to adopt an interface’s contract, unlike extends for class inheritance.
    -Java allows implementing multiple interfaces but extending only one class to avoid implementation conflicts from multiple class inheritance.
 *Purpose of Interfaces:
    -Define capabilities (e.g., Comparable for sorting) via method signatures, ensuring classes provide specific functionality.
    -Example: Comparable interface with int cmp(Object o) enables sorting by requiring classes to implement comparison logic (-1 for less, 0 for equal, 1 for greater).
    -Interfaces specify method signatures but cannot enforce correct behavior, relying on implementers to follow conventions (e.g., cmp returning -1, 0, 1).
 *Multiple Inheritance:
    -Interfaces avoid conflicts of multiple class inheritance since they lack concrete implementations, allowing safe multiple interface implementation.
    -Example: A class can implement Comparable and another interface (e.g., Drawable) without ambiguity, as implementations are provided by the class.
    -Static and Default Methods in Interfaces:
 *Static Methods: 
    -Added to interfaces (e.g., Comparable.cmpDoc() returning a documentation string) to provide utility functions without needing objects.
 *Default Methods: 
    -Provide a default implementation (e.g., default int cmp(Object o) { return 0; }) that classes can use or override, useful when some methods are optional.
    -Purpose: Enhance interface flexibility, allowing shared or fallback behavior without requiring every class to implement all methods.
 *Conflict Resolution:
 *Multiple Interfaces: 
    -If two interfaces provide default methods with the same signature (e.g., Person.getName() vs. Designation.getName()), the implementing class must override the method to resolve the conflict.
 *Class vs. Interface: 
    -If a class extends a superclass and implements an interface with conflicting methods, the superclass’s method takes precedence for backward compatibility.
 *Reason: 
    -Ensures legacy code remains functional when interfaces are updated with new default methods.
 *Challenges and Evolution:
    -Adding static/default methods reintroduces potential conflicts, partially undermining the original intent of interfaces to avoid multiple inheritance issues.
    -Java’s evolution balances new features (e.g., default methods) with backward compatibility, constraining design to prevent breaking existing code.
    -Multiple class inheritance remains disallowed due to complexity, but multiple interface implementation is supported as a safer alternative.
 *Takeaway:
    -Interfaces define abstract capabilities, ensuring classes implement required methods while supporting multiple inheritance safely.
    -Static and default methods add flexibility but require conflict resolution rules to maintain consistency.
    -Java’s design reflects a trade-off between evolving functionality and maintaining compatibility with legacy code. 
    */


    // This program demonstrates interfaces in Java, including static and default methods, conflict resolution, and their use in sorting with Comparable.

// Interface defining comparison capability
interface Comparable {
    // Abstract method for comparison
    int cmp(Object o);

    // Static method providing documentation for cmp
    static String cmpDoc() {
        return "Returns -1 if this < o, 0 if equal, 1 if this > o";
    }

    // Default method providing a fallback implementation
    default int defaultCmp(Object o) {
        return 0; // Default: objects are equal
    }
}

// Interface defining a Person with a name
interface Person {
    // Default method for name
    default String getName() {
        return "No name";
    }
}

// Interface defining a Designation with a role
interface Designation {
    // Default method for name (conflicts with Person)
    default String getName() {
        return "No designation";
    }
}

// Employee class extending a superclass and implementing multiple interfaces
class BaseEmployee {
    // Concrete method in superclass
    public String getName() {
        return "Base employee";
    }
}

class Employee extends BaseEmployee implements Person, Designation {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    // Must override getName to resolve conflict between Person and Designation
    @Override
    public String getName() {
        return name; // Overrides both interface default methods
    }
}

// Circle class implementing Comparable for sorting by radius
class Circle implements Comparable {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    // Implement cmp for sorting by radius
    @Override
    public int cmp(Object o) {
        if (!(o instanceof Circle)) {
            throw new IllegalArgumentException("Can only compare with Circle");
        }
        Circle other = (Circle) o;
        double diff = this.radius - other.radius;
        return diff < 0 ? -1 : (diff == 0 ? 0 : 1);
    }

    public double getRadius() {
        return radius;
    }
}

// Utility class for sorting Comparable objects
class SortUtil {
    // Static method to sort an array of Comparable objects
    public static void quicksort(Comparable[] arr, int low, int high) {
        Roslyn
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

// Main class to demonstrate interface usage
public class InterfaceDemo {
    public static void main(String[] args) {
        // Demonstrate Comparable interface and sorting
        System.out.println("Comparable interface documentation: " + Comparable.cmpDoc());
        Comparable[] circles = {
            new Circle(3.0), // Radius: 3.0
            new Circle(5.0), // Radius: 5.0
            new Circle(2.0)  // Radius: 2.0
        };

        System.out.println("\nCircles before sorting:");
        for (Comparable c : circles) {
            System.out.printf("Circle radius: %.2f%n", ((Circle) c).getRadius());
        }

        SortUtil.quicksort(circles, 0, circles.length - 1);

        System.out.println("\nCircles after sorting by radius:");
        for (Comparable c : circles) {
            System.out.printf("Circle radius: %.2f%n", ((Circle) c).getRadius());
        }

        // Demonstrate conflict resolution with Employee
        System.out.println("\nEmployee name resolution:");
        Employee emp = new Employee("John Doe");
        System.out.println("Employee name: " + emp.getName()); // Uses Employee's implementation
        System.out.println("From Person interface: " + ((Person) emp).getName());
        System.out.println("From Designation interface: " + ((Designation) emp).getName());
    }
}