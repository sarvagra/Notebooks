/*print the pattern:
A B C D E F 
A B C D E F 
A B C D E F 
A B C D E F 
A B C D E F 
A B C D E F when n=6 */
package Patterns;           
import java.util.*;


public class AlphaPattern {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of rows");
        int n=sc.nextInt();
        
        for (int i=1;i<=n;i++){
            char alpha='A';
            for (int j=1;j<=n;j++){
                
                System.out.print((alpha)+" ");
                alpha++;
            }System.out.println();
        }
    }
}
