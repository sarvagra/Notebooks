/*Summary lecture 3
    * A subclass extends a parent class, and process of creating a subclass is called subclassing.

    * Private instance variable of a parent class are not accessible to its child class, it requires keyword super to access them.

    * A subclass can override a method from parent class with same signatue (name, parameters, return-type)
        Example: The Manager class overrides the bonus method to compute a bonus differently (e.g., 1.5 times the employee’s bonus)
        -> The super keyword allows the subclass to call the parent’s version of the method (e.g., super.bonus(percentage) * 1.5)

    * Dynamic dispatch(rutime polymorhism): Java uses dynamic dispatch to determine which method to call based on the actual (runtime) type of the object, not its declared (static) type.
        Example: If an Employee variable e points to a Manager object (Employee e = new Manager();), calling e.bonus(0.05) invokes the Manager’s bonus method, not the Employee’s, due to dynamic dispatch.
        -> This is also called runtime polymorphism or inheritance polymorphism, as the method chosen depends on the object’s position in the inheritance hierarchy.

    * Static type: The declared type of a variable (e.g., Employee e).

    * Dynamic type: The actual type of the object at runtime (e.g., Manager if e = new Manager()).
        Example: e.setSecretary() is invalid because setSecretary is not defined in Employee, even if e points to a Manager at runtime.

    * Type-Casting : To access subclass-specific methods (e.g., setSecretary), you can cast the variable to the subclass type: ((Manager)e).setSecretary("Jane").
        -> Casting is risky if the object is not actually an instance of the target type, leading to a runtime ClassCastException.
        -> Use the instanceof operator to check the runtime type before casting: if (e instanceof Manager) { ((Manager)e).setSecretary("Jane"); }

    * Reflection : Reflection allows a program to inspect its own structure at runtime (e.g., checking an object’s type with instanceof).
        -> This is a form of introspection, where the program queries metadata about itself (e.g., e instanceof Manager checks if e is a Manager)
        -> Beyond instanceof, Java’s reflection API (e.g., java.lang.reflect) allows inspecting classes, methods, and fields at runtime. Example: e.getClass().getMethods()
    
    * Polymorphism : 
        Runtime Polymorphism: Achieved through method overriding and dynamic dispatch, as described above.
            Example: The Arrays.sort method has different implementations for int[], double[], etc.

        Overloading: A different form of polymorphism where multiple methods share the same name but have different signatures (parameter types or number). The correct method is chosen at compile time based on the static type of the arguments.
            Example: The Arrays.sort method has different implementations for int[], double[], etc.

        Structural Polymorphism (Generics): A third form where a function works on any type that satisfies a specific property (e.g., comparability). This is implemented in Java using generics (e.g., Comparable interface for sorting).

    * Heterogeneous Collections and Dynamic Dispatch:
        An array or collection of a parent type (e.g., Employee[]) can hold objects of its subclasses (e.g., Manager).
            Example: Employee[] empArray = {new Employee(), new Manager()};. 
            When iterating and calling empArray[i].bonus(0.05), dynamic dispatch ensures the correct bonus method is called for each object’s actual type (Employee or Manager).

 */

 
// Employee class represents a basic employee with a name and salary
class Employee {
    // Private instance variables to store employee's name and salary
    private String name;
    private double salary;

    // Constructor to initialize an Employee object with a name and salary
    public Employee(String name, double salary) {
        this.name = name; // Assign the provided name to the instance variable
        this.salary = salary; // Assign the provided salary to the instance variable
    }

    // Method to calculate a bonus based on a percentage of the salary
    public double bonus(float percentage) {
        return salary * percentage; // Returns the bonus as a percentage of the salary
    }

    // Getter method to retrieve the employee's name
    public String getName() { 
        return name; 
    }

    // Getter method to retrieve the employee's salary
    public double getSalary() { 
        return salary; 
    }
}

// Manager class extends Employee, inheriting its properties and methods
class Manager extends Employee {
    // Additional instance variable specific to Manager
    private String secretary;

    // Constructor to initialize a Manager with name, salary, and secretary
    public Manager(String name, double salary, String secretary) {
        super(name, salary); // Call the parent (Employee) constructor to initialize name and salary
        this.secretary = secretary; // Initialize the manager-specific secretary field
    }

    // Override the bonus method to provide a custom bonus calculation for managers
    @Override
    public double bonus(float percentage) {
        // Call the parent class's bonus method and increase the result by 50%
        return super.bonus(percentage) * 1.5; // Manager gets 1.5x the employee's bonus
    }

    // Method to set the secretary's name
    public void setSecretary(String secretary) {
        this.secretary = secretary; // Update the secretary field
    }

    // Getter method to retrieve the secretary's name
    public String getSecretary() { 
        return secretary; 
    }
}

// Main class to demonstrate the Employee and Manager classes
public class L3 {
    public static void main(String[] args) {
        // Create an array of Employee objects, which can hold both Employee and Manager objects
        // This demonstrates polymorphism, as Manager is a subclass of Employee
        Employee[] empArray = {
            new Employee("Alice", 50000), // Regular employee with name "Alice" and salary 50,000
            new Manager("Bob", 80000, "Jane") // Manager with name "Bob", salary 80,000, and secretary "Jane"
        };

        // Loop through the array to calculate and print each employee's bonus
        // Demonstrates dynamic dispatch: the correct bonus method is called based on the object's runtime type
        for (Employee e : empArray) {
            System.out.println(e.getName() + "'s bonus: " + e.bonus(0.05f)); // 5% bonus
            // For Employee: bonus = 50,000 * 0.05 = 2,500
            // For Manager: bonus = (80,000 * 0.05) * 1.5 = 6,000
        }

        // Demonstrate type casting to access Manager-specific methods
        Employee e = new Manager("Charlie", 90000, "Eve"); // Employee variable pointing to a Manager object
        // Check if the object is an instance of Manager to avoid ClassCastException
        if (e instanceof Manager) {
            // Cast e to Manager to access Manager-specific methods
            ((Manager)e).setSecretary("Grace"); // Update secretary to "Grace"
            System.out.println("Secretary: " + ((Manager)e).getSecretary()); // Print the secretary's name
        }
    }
}