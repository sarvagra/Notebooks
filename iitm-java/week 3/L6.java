/* Summary Lecture on Java Modifiers in Object-Oriented Programming

- **Purpose of Modifiers**:
  - Java uses modifiers to manage encapsulation, object creation, and immutability in object-oriented programming, addressing relationships between types and their components.

- **Public and Private Modifiers**:
  - **Public**: Allows access to fields, methods, or classes from outside the class, enabling interaction with the object’s interface.
  - **Private**: Restricts access to within the class, used for encapsulation to hide implementation details (e.g., private instance variables like `salary` in `Employee`).
  - **Example**: In a `Stack` class, instance variables (`array`, `tos`, `size`) are private to encapsulate state, while methods (`push`, `pop`, `isEmpty`) are public for interaction.
  - **Private Methods**: Used for internal helper functions not exposed to users. Example: A private `extendStack` method in `Stack` doubles the array size when full, called internally by `push` to handle overflow gracefully.

- **Accessor and Mutator Methods**:
  - **Accessors**: Public methods that query private fields without modifying them (e.g., `getDay`, `getMonth`, `getYear` in a `Date` class).
  - **Mutators**: Public methods that update private fields (e.g., `setDay`, `setMonth`, `setYear`).
  - **Issue with Independent Mutators**: Updating fields like day, month, and year independently can lead to invalid states (e.g., setting June 31). A single mutator (e.g., `setDate(day, month, year)`) validates the combination before updating to ensure consistency.

- **Static Modifier**:
  - **Purpose**: Defines fields or methods that exist without creating an object, associated with the class itself.
  - **Examples**:
    - Static methods: Library functions like `Math.sqrt` or `Arrays.sort` don’t require an object.
    - Static fields: Constants like `Math.PI` or `Integer.MAX_VALUE` exist independently.
    - Static `main` method: Entry point of a program, runs without an object.
  - **Private Static Fields**: Used for class-wide bookkeeping. Example: A private static `lastOrderId` tracks the last assigned order ID across all `Order` objects, incremented in the constructor to assign unique IDs.
  - **Caution**: Shared static fields updated by multiple objects (e.g., in concurrent systems like online shopping) require careful handling to avoid conflicts (e.g., two orders getting the same ID). This is addressed later in concurrency topics.

- **Final Modifier**:
  - **Purpose**: Prevents modification of variables, methods, or classes.
  - **Final Variables**: Used for constants (e.g., `public static final double PI = 3.14159` in `Math`), ensuring they cannot be reassigned.
  - **Final Methods**: Prevents subclasses from overriding the method, controlling subtyping behavior. Example: A final method in a parent class cannot be redefined in a subclass, ensuring consistent behavior.
  - **Note**: In Java, methods are fixed at compile-time (unlike Python’s runtime redefinition), but `final` prevents overriding in subclasses.

- **Combining Modifiers**:
  - Modifiers like `public`, `private`, `static`, and `final` are orthogonal and can be combined in meaningful ways.
  - **Example: Private Static**: A private static field like `lastOrderId` is shared across all objects but only accessible within the class, ideal for tracking global state (e.g., unique order IDs or method call counts for profiling).
  - **Example: Public Static Final**: Used for constants like `Math.PI`, accessible globally but immutable.
  - **Example: Private Methods**: Helper methods like `extendStack` in `Stack` are private to hide implementation details but critical for internal logic.

- **Modifiers and Classes**:
  - Modifiers can apply to classes (e.g., `public` or `private` classes). Private classes (discussed later) are used in specific contexts, such as inner classes, to restrict access.

- **Takeaway**:
  - Modifiers enable fine-grained control over encapsulation (`public`, `private`), object-independent behavior (`static`), and immutability (`final`).
  - Understanding their combinations (e.g., `private static`, `public final`) is key to designing robust classes, ensuring encapsulation, consistency, and controlled inheritance/subtyping behavior.
*/


// This program demonstrates the use of Java modifiers (public, private, static, final) through a Stack class and an Order class, illustrating encapsulation, static bookkeeping, and immutability as discussed in the lecture.


class Date {
    // Private instance variables for encapsulation
    private int day, month, year;

    // Constructor initializes a valid date
    public Date(int day, int month, int year) {
        if (isValidDate(day, month, year)) {
            this.day = day;
            this.month = month;
            this.year = year;
        } else {
            throw new IllegalArgumentException("Invalid date");
        }
    }

    // Public accessor methods to query private fields
    public int getDay() { return day; }
    public int getMonth() { return month; }
    public int getYear() { return year; }

    // Public mutator method to set date, ensuring consistency
    public void setDate(int day, int month, int year) {
        if (isValidDate(day, month, year)) {
            this.day = day;
            this.month = month;
            this.year = year;
        } else {
            throw new IllegalArgumentException("Invalid date");
        }
    }

    // Private helper method to validate date
    private boolean isValidDate(int day, int month, int year) {
        if (month < 1 || month > 12 || day < 1 || year < 0) {
            return false;
        }
        int[] daysInMonth = {31, isLeapYear(year) ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        return day <= daysInMonth[month - 1];
    }

    // Private helper method to check for leap year
    // Ensures accurate validation of February 29th based on year divisibility
    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}

// Order class demonstrating private static and final modifiers
class Order {
    // Private static variable to track the last assigned order ID
    private static int lastOrderId = 0;
    // Private final instance variable for unique order ID
    private final int orderId;
    private String item;

    // Constructor assigns a unique order ID
    public Order(String item) {
        this.orderId = ++lastOrderId; // Increment and assign unique ID
        this.item = item;
    }

    // Public accessor for order ID
    public int getOrderId() { return orderId; }

    // Public accessor for item
    public String getItem() { return item; }

    // Public static method to access last assigned order ID
    public static int getLastOrderId() { return lastOrderId; }
}

// Main class to demonstrate the use of modifiers
public class ModifiersDemo {
    // Static main method, runs without creating an object
    public static void main(String[] args) {
        // Demonstrate Date class
        System.out.println("Testing Date class:");
        try {
            Date date = new Date(29, 2, 2020); // Valid leap year date
            System.out.println("Date: " + date.getDay() + "/" + date.getMonth() + "/" + date.getYear());
            date.setDate(31, 4, 2020); // Invalid date (April has 30 days)
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Demonstrate Order class
        System.out.println("\nTesting Order class:");
        Order order1 = new Order("Laptop");
        Order order2 = new Order("Phone");
        System.out.println("Order 1 ID: " + order1.getOrderId() + ", Item: " + order1.getItem());
        System.out.println("Order 2 ID: " + order2.getOrderId() + ", Item: " + order2.getItem());
        System.out.println("Last Order ID: " + Order.getLastOrderId());
    }
}