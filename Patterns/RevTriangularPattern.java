/*print the pattern :
@@@@@
@@@@
@@@
@@
@       when n=5; */

package Patterns;
import java.util.Scanner;

public class RevTriangularPattern {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of rows");
        int n=sc.nextInt();
        for (int i=n;i>=0;i--){
            for(int j=1;j<=i;j++){
                System.out.print("@");
            }System.out.println();
        }
    }
}
