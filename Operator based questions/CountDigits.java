import java.util.*;

public class CountDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number");
        int n = sc.nextInt();
        int i = 0;

        while (n != 0) {
            n = n / 10; 
            i++;      
        }

        System.out.println("Number of digits: " + i);
    }
}


