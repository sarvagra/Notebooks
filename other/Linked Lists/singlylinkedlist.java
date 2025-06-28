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
        
        sll.insertg(1,88);
        sll.insertf(9);
        sll.insertl(69);
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

    // insert a new element in the beginning of a sll

    public void insertf(int value)
    {
        ListNode newnode = new ListNode(value);
        newnode.next=head;
        head=newnode;
    }

    // insert a new element in the end of a sll

    public void insertl(int value)
    {
        ListNode newnode = new ListNode(value);
        ListNode current=head;
        if(head==null)
        {
            head=newnode;
            return;
        }
        while(current.next!=null)
        {
            current=current.next;
        }
        current.next=newnode;
    }
    

    // insert a new element in the given position of a sll
    // with steps
    public void insertg(int pos,int value)  //create a function to store position and value
    {
        ListNode node = new ListNode(value); //create a new node with the value that has to be inserted.
        
        if(pos==1) // when position is one, element has to be inserted before one.
        {
            node.next=head;
            head=node;
        }
        else
        {
            ListNode previous=head;
            int count=1;
            while(count<pos-1)
            {
                previous=previous.next;
                count++;
            }
            ListNode current = previous.next;
        }
        
    }
}