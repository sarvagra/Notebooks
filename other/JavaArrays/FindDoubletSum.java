package JavaArrays;
import java.util.Scanner;

public class FindDoubletSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input size of the array
        System.out.println("Enter the size of array:");
        int s = sc.nextInt();
        int[] arr = new int[s];

        // Input array elements
        System.out.println("Enter the elements in the array:");
        for (int i = 0; i < s; i++) {
            arr[i] = sc.nextInt();
        }

        // Input the target sum
        System.out.println("Enter the number to find its doublet sum elements:");
        int num = sc.nextInt();

        // Initialize flag for tracking if a doublet is found
        boolean flag = false;

        // Loop through the array to find doublets
        for (int i = 0; i < s; i++) {
            for (int j = i + 1; j < s; j++) { // Start from i+1 to avoid duplicates
                if (arr[i] + arr[j] == num) {
                    System.out.println("The doublet which has sum = " + num + " are " + arr[i] + " and " + arr[j]);
                    flag = true;
                }
            }
        }

        // If no doublets are found
        if (flag==false) {
            System.out.println("No doublet present.");
        }
    }
}
