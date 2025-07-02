/* Summary of Private Classes and Their Role in Encapsulation

 * Objects can contain other objects as members  
    - Example: An `Employee` object may use a `Date` class to store the joining date.

 * Public nested classes are accessible globally  
    - If `Date` is public, other classes besides `Employee` can use it freely.

 * Not all internal structures should be exposed  
    - In a `LinkedList`, the `Node` class is only relevant to the list's internal logic, not the external interface.

 * Implementation details like Node should be hidden  
    - Users of `LinkedList` shouldn't know or care whether nodes have one or two pointers (e.g., for singly or doubly linked lists).

 * Encapsulation demands hiding such internals  
    - Exposing `Node` breaks abstraction and couples users to internal design choices.

 * Use private inner classes to hide implementation  
    - Defining `Node` as a private class within `LinkedList` makes it invisible outside, ensuring clean abstraction.

 * Private inner classes must be defined inside their outer class  
    - A `private` class can't exist at the top level—must be nested within another class.

 * Private inner classes can access all members (even private) of the outer class  
    - The `Node` class can access `LinkedList`'s `size`, `first`, or any private field.

 * Outer class can also access private inner class freely  
    - `LinkedList` can create and manipulate `Node` objects, despite `Node` being private.

 * Private doesn't mean invisible inside the class  
    - Just like objects of the same class can access each other’s private fields, inner classes and outer classes share visibility.

 * Benefit: Better encapsulation and flexibility  
    - Internal structures like `Node` can be modified (e.g., add `prev` pointer) without affecting external code.

 * Foundation for more advanced access control  
    - Combining private classes with interfaces allows finely controlled access to internal object state.

 * Conclusion: Private inner classes promote robust design  
    - They enforce separation of interface and implementation, allowing internal changes without breaking external usage.
*/


// LinkedList.java
public class LinkedList {
    private Node head;      // points to the first node in the list
    private int size = 0;   // tracks the number of elements in the list

    // Private inner class Node - hidden from outside
    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    // Adds a new element to the front of the list
    public void addFirst(int value) {
        Node newNode = new Node(value);  // accessible here despite being private
        newNode.next = head;
        head = newNode;
        size++;
    }

    // Removes and returns the first element
    public int removeFirst() {
        if (head == null) {
            throw new IllegalStateException("List is empty.");
        }
        int value = head.data;
        head = head.next;
        size--;
        return value;
    }

    // Returns the current size of the list
    public int getSize() {
        return size;
    }

    // Prints the elements of the list (for demonstration)
    public void printList() {
        Node current = head;
        System.out.print("List: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

// Main.java
public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.addFirst(10);
        list.addFirst(20);
        list.addFirst(30);

        list.printList();  // Output: List: 30 20 10
        System.out.println("Removed: " + list.removeFirst()); // Output: 30
        list.printList();  // Output: List: 20 10
        System.out.println("Size: " + list.getSize());        // Output: 2

        // The following is illegal and will not compile:
        // LinkedList.Node node = new LinkedList.Node(100); // Cannot access private class
    }
}
