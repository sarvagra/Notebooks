// Arrays 

/* #1 an array is declared by the syntax : <data type> <name> [] or <data type>[] <name>;
   #2 initialization :  <name>=new <data type>[size]; 
   #3 declaration+intitialization: <data type>[] <name>=new <data type>[size]; 
   #4 manual initialization : <data type>[] <name>={data};
   #5 default value of any element in an array is 0.
*/

public class array
{
    public static void main(String[] args) 
    {
        int[] myarray; //#1
        myarray = new int [10]; //#2
        int[] myarr = new int[5]; //#3
        double[] data = {2.33,434.4,98.08};
    }
}