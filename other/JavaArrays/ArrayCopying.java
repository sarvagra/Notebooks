package JavaArrays;

import java.util.Arrays;

public class ArrayCopying {
    public static void main(String[] args) {
        int[] arr={30,34,56,99,69}; //define an array arr.
        for(int x :arr){
            System.out.print(x+" ");
        }System.err.println();
        int[] nums =arr; //copy the value of arr to a new array  nums/
        nums[0]=44;  //modefy the value of nums.
        for(int x : nums){
            System.out.print(x+" "); //print the modefied array nums.
            
        }System.out.println();
        for(int x : arr){
            System.out.print(x+" "); //print the array arr and notice that the change made in nums is also reflecting in arr.
            
        }System.err.println();
        
        //what to do to retain the original value of array arr:
        
        int[] n={30,34,56,99,69};
        //deep copying 
        int[] brr=Arrays.copyOf(arr,arr.length); //copy while retaining original values.
        brr[0]=99;
        for(int x : brr){
            System.out.print(x+" "); //print the array arr and notice that the change made in nums is also reflecting in arr.
            
        }System.err.println();
        for(int x : n){
            System.out.print(x+" "); //print the array arr and notice that the change made in nums is also reflecting in arr.
            
        }
    }
}
