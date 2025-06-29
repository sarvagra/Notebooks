/* Summary Lecture on Subtyping and Inheritance

- **Subtyping**:
  - Subtyping describes a relationship where a subtype (child class) has all capabilities of its supertype (parent class) and possibly more.
  - Allows substituting a subtype object where a supertype is expected (e.g., a `Manager` object can be assigned to an `Employee` variable).
  - Ensures all methods available in the supertype are available in the subtype, with dynamic dispatch invoking the subtype’s overridden method at runtime.
  - Example: A `Deque` is a subtype of both `Queue` and `Stack` because it supports all their operations (insert/delete at specific ends) and more (operations at both ends).

- **Inheritance**:
  - Inheritance focuses on code reuse, where a subclass reuses or extends the implementation of its parent class.
  - A subclass may call the parent’s methods using `super` to build upon existing functionality.
  - Example: The `Manager` class inherits from `Employee` and reuses the `bonus` method by calling `super.bonus(percentage) * 1.5` to compute a modified bonus.
  - Example: Both `Queue` and `Stack` can inherit from `Deque` by restricting operations to specific ends, reusing `Deque`’s implementation.

- **Key Distinction**:
  - Subtyping is about interface compatibility (compile-time): A subtype must support all supertype operations.
  - Inheritance is about implementation reuse: A subclass reuses or extends the parent’s code.
  - In Java, the class hierarchy (using `extends`) represents both subtyping and inheritance, which can blur their distinction.
  - Example: `Deque` is a subtype of `Queue` and `Stack` (supports their interfaces), but `Queue` and `Stack` inherit from `Deque` (reuse its implementation by restricting operations).

- **Class Hierarchy in Java**:
  - Java’s single inheritance model (tree-like hierarchy) forces both subtyping and inheritance to be expressed through `extends`, even though they are conceptually distinct.
  - Example: In the `Employee`/`Manager` case, subtyping and inheritance align (`Manager` is a subtype and reuses `Employee`’s code), but in the `Deque`/`Queue`/`Stack` case, subtyping (`Deque` → `Queue`/`Stack`) and inheritance (`Queue`/`Stack` → `Deque`) go in opposite directions.

- **Practical Example**:
  - `Manager` is a subtype of `Employee`: A `Manager` object can be used anywhere an `Employee` is expected, and dynamic dispatch ensures the `Manager`’s overridden `bonus` method is called.
  - `Manager` inherits from `Employee`: It reuses the `Employee`’s `bonus` method via `super.bonus()` to compute its own bonus.
  - `Deque` vs. `Queue`/`Stack`: `Deque` is a subtype (supports all operations), but `Queue` and `Stack` inherit from `Deque` by limiting functionality to specific operations.

- **Dynamic Dispatch and Polymorphism**:
  - Subtyping enables runtime polymorphism via dynamic dispatch, where the method called depends on the object’s runtime type.
  - Example: `Employee e = new Manager(...); e.bonus(0.05f)` calls `Manager`’s `bonus` method due to dynamic dispatch.

- **Takeaway**:
  - Subtyping ensures interface compatibility; inheritance focuses on code reuse.
  - Java’s class hierarchy conflates these concepts, but understanding their distinction clarifies design decisions in object-oriented programming.
*/

// Interface defining a basic Queue with insertRear and deleteFront operations
interface Queue {
    void insertRear(int element); // Add element to the rear of the queue
    int deleteFront(); // Remove and return element from the front of the queue
}

// Interface defining a basic Stack with push (insertFront) and pop (deleteFront) operations
interface Stack {
    void insertFront(int element); // Push element onto the top (front) of the stack
    int deleteFront(); // Pop and return element from the top (front) of the stack
}

// Interface defining a Deque (double-ended queue) with operations at both ends
interface Deque extends Queue, Stack {
    void insertFront(int element); // Add element to the front of the deque
    int deleteRear(); // Remove and return element from the rear of the deque
}

// Concrete Deque implementation using a dynamic array (simplified for demonstration)
class ArrayDeque implements Deque {
    private int[] elements; // Array to store deque elements
    private int front; // Index of the front element
    private int rear; // Index of the rear element
    private int size; // Current number of elements
    private static final int CAPACITY = 100; // Fixed capacity for simplicity

    // Constructor initializes an empty deque
    public ArrayDeque() {
        elements = new int[CAPACITY];
        front = 0;
        rear = -1;
        size = 0;
    }

    // Implements Queue's insertRear: adds element to the rear
    @Override
    public void insertRear(int element) {
        if (size == CAPACITY) {
            throw new IllegalStateException("Deque is full");
        }
        rear = (rear + 1) % CAPACITY; // Circular increment
        elements[rear] = element;
        size++;
    }

    // Implements Queue and Stack's deleteFront: removes element from the front
    @Override
    public int deleteFront() {
        if (size == 0) {
            throw new IllegalStateException("Deque is empty");
        }
        int element = elements[front];
        front = (front + 1) % CAPACITY; // Circular increment
        size--;
        return element;
    }

    // Implements Deque's insertFront: adds element to the front
    @Override
    public void insertFront(int element) {
        if (size == CAPACITY) {
            throw new IllegalStateException("Deque is full");
        }
        front = (front - 1 + CAPACITY) % CAPACITY; // Circular decrement
        elements[front] = element;
        size++;
    }

    // Implements Deque's deleteRear: removes element from the rear
    @Override
    public int deleteRear() {
        if (size == 0) {
            throw new IllegalStateException("Deque is empty");
        }
        int element = elements[rear];
        rear = (rear - 1 + CAPACITY) % CAPACITY; // Circular decrement
        size--;
        return element;
    }
}

// Queue implementation that inherits from ArrayDeque, restricting to Queue operations
class SimpleQueue extends ArrayDeque {
    // Constructor calls parent constructor
    public SimpleQueue() {
        super();
    }

    // Inherits insertRear and deleteFront from ArrayDeque (Queue interface)
    // No need to override, as ArrayDeque's implementation is reused
    // Other methods (insertFront, deleteRear) are not exposed, enforcing Queue behavior
}

// Stack implementation that inherits from ArrayDeque, restricting to Stack operations
class SimpleStack extends ArrayDeque {
    // Constructor calls parent constructor
    public SimpleStack() {
        super();
    }

    // Inherits insertFront and deleteFront from ArrayDeque (Stack interface)
    // No need to override, as Array