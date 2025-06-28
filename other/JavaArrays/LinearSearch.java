// program to search an element in an arrray using linear search.
package JavaArrays;
import java.util.*;
public class LinearSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of the array.");
        int n =sc.nextInt();
        boolean flag=false;
        int[] arr =new int[n];
        System.out.println("Enter elements of the array.");
        for(int i =0; i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("Enter element to be searched");
        int ele=sc.nextInt();
        for (int i=0; i<n;i++){
            if(arr[i]==ele){
                System.out.println("Element Found, Idex="+i);
                flag=true;
                break;
            }

        }
        if (flag==false)
        System.out.println("Element not found");
    }

}
