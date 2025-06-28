package JavaArrays;

import java.util.Scanner;

public class RotateArrayTwoPointer {
    public static void main(String[] args) {
        Scanner sc=new Scanner (System.in);
        System.out.println("Enter the size of array:");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter the elements in array:");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt(); 
        }
         //using while loop approach:

         int i=0,j=arr.length-1,t=0;
         while(i<j){
            t=arr[i];
            arr[i]=arr[j];
            arr[j]=t;
            i++;
            j--;
         }
         for(int k:arr){
            System.out.print(k+", ");
        }System.out.println();

         //using for loop approach:
         
         int k = arr.length;
         j=k-1;
         for(int p=0;p<k/2;p++){
            t=arr[p];
            arr[p]=arr[j];
            arr[j]=t;
            j--;
         }
         for(int q:arr){
            System.out.print(q+", ");
        }

    }
}
