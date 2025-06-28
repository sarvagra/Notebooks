/*print the pattern :
1 
1 3 
1 3 5 
1 3 5 7 
1 3 5 7 9  when n=5; */

package Patterns;
import java.util.Scanner;

public class TriangularPattern {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of rows");
        int n=sc.nextInt();
        for (int i=1;i<=n;i++){
            int k=1;
            for(int j=1;j<=i;j++){
                System.out.print(k+" ");
                k+=2;
            }System.out.println();
        }
    }
}