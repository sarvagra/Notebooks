package JavaArrays;

import java.util.*;
public class BasicOperations {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[] arr=new int[5]; //declaration of an array of length 5.
        System.out.println("Enter the elements in your array");
        for(int i=0;i<5;i++){  //taking input for elements in array.
            arr[i]=sc.nextInt();
        }
        for(int i=0;i<5;i++){  //printing elements in the array.
            System.out.print(arr[i]+" ");

        }System.out.println();

        // initializing an array when we dont know the size
        int[] arr2={22,34,56,78,99,69,56};
        // get the index number of any element in array.
        for(int i =0;i<(arr.length);i++){
            if (arr2[i]==34){
                System.out.println("Index="+i);
            }
        }
    }
    
}
