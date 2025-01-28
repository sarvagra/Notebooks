package JavaArrays;

import java.util.Scanner;

public class Sort0sAnd1s {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array:");
        int s = sc.nextInt();
        int[] x = new int[s];
        System.out.println("Enter the elements in the array:");
        for (int i = 0; i < s; i++) {
            x[i] = sc.nextInt();
        }

        // Sorting using count technique:
        int ones = 0;
        for (int i : x) {
            if (i == 1) {
                ones++;
            }
        }
        System.out.println("Ones: " + ones);
        for (int i = 0; i < x.length; i++) {
            if (i < x.length - ones) {
                x[i] = 0;
            } else {
                x[i] = 1;
            }
        }

        for (int i : x) {
            System.out.print(i + " ");
        }
    }
}
