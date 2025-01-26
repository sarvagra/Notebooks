package JavaArrays;
import java.util.ArrayList;
public class ArrayLists {
    public static void main(String[] args) {
        //declaration & initialization
        ArrayList<Integer> arr=new ArrayList<>(6);
        
        //adding values
        arr.add(0,2010);
        arr.add(1,2011);
        arr.add(2,2012);
        arr.add(3,2013);
        arr.add(4,2014);
        arr.add(5,2015);

        //extracting values from the array:
        for(int i :arr)
        System.out.print(i+" "); // or-  arr.get(index)
        System.out.println();

        //to print entire array list:
        System.out.println(arr); 
        /* note that arrays have default value of 0 so they can be printed 
         * without initializing, but ArrayLists are not, so they cant be 
         * printed without initialization
         */

         //to change or modefy an element in ArayList, use name.set(index,new value);
         arr.set(0,2009);
         System.out.println(arr);
        
         //to get size of an ArrayList, use: name.size();
         System.out.println("Size of array:"+arr.size());

         /* when we want too add an element to the array list from the end 
          * (even when initial size exceeds), use : name.add(element)
          */
         arr.add(69);

         System.out.println(arr); //notice that the element is added despite initial size of array was pre-occupied
         System.out.println("Size of array:"+arr.size()); //also notice the increase in size 
         

         // to remove element from anywhere in the ArrayList, use : name.remove(index)
         arr.remove(6);
         System.out.println("new list after removing:"+arr);
           
         /* when we create an ArrayList without any size declaration, the size of array list is 0. As we keep adding 
          * the elements its size increases accordingly.
          */

         ArrayList<String> names= new ArrayList<>();
         System.out.println("Size of array:"+names.size());
         names.add(0,"Sa");
         names.add(1,"rv");
         names.add(2,"ag");
         names.add(3,"ra");
         System.out.println(names);
         System.out.println("Size after adding elements: "+names.size());


         
         
    }
}
