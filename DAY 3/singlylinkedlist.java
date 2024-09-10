
//this code is a basic approach to understanding a linked list and creating one.

class singlylinkedlist 
{
    ListNode head;

    static class ListNode 
    {
        int data;
        ListNode next,current;

        // Constructor to initialize data and next
        ListNode(int data) 
        {
            this.data = data;
            this.next = null;
        }
    }
    
    public static void main(String[] args) {
        singlylinkedlist sll=new singlylinkedlist(); //create an object
        sll.head=new ListNode(10);
        ListNode second = new ListNode(1);
        ListNode third = new ListNode(8);
        ListNode fourth = new ListNode(11);

        //connect the nodes to form a chain

        sll.head.next =second; //10 -> 1
        second.next=third; //1 -> 8
        third.next=fourth; //8 -> 11 -> null

        sll.display(); //call the display method to print the list
        System.out.println("Length :"+sll.length()); //call the length method to [rint the length of a singly linked list.
    }   
    
    public void display()  // priniting the elements of a singly linked list.
    {
        ListNode current = head;
        while(current!=null)
        {
            System.out.print(current.data+" -> ");
            current=current.next;
        }
        System.out.println("Null");
    }   

    public int length()
    {
        if(head==null)
        return 0;
        int count=0;
        ListNode current=head;
        while(current!=null)
        {
            count++;
            current=current.next;
        }
        return count;
    }
    
}






