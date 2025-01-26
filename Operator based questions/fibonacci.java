//print fibonacci series upto n terms
import java.util.*;
public class fibonacci {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int t= sc.nextInt();
        int first=0,second=1,third=0;
        for(int i=0;i<t;i++){
            System.out.print(first+",");
            third=first;
            first=first+second;
            second=third;

            }
 
    }
}
