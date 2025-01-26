/*print the pattern:
A B C D E F 
A B C D E F 
A B C D E F 
A B C D E F 
A B C D E F 
A B C D E F when n=6 */
package Patterns;

import java.util.Scanner;

public class NumberPattern {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of rows");
        int n=sc.nextInt();
        char alpha='A';
        for (int i=1;i<=n;i++){
            for (int j=1;j<=n;j++){
                
                System.out.print(j+" ");
                
            }System.out.println();
        }
    }
}
