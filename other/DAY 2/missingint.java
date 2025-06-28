// this program finds the missing integer in an array of lenght n-1 having numbers from 0 to n.
//here we take the value of n to be 9

class missingint {
    public static void main (String[] args)
    {
        int[] a= {1,9,7,5,4,3,2,8};
        int i, j ,t=0,n=9;
        int check=(n*(n+1)/2);

        //calculate the sum of all the numbers in the array.
        for(i=0;i<a.length;i++)
        {
            t=t+a[i];
        }
        //find the difference of the sum of numbers from 1 to n whih is the missing number.
        i=check-t;
        System.out.println("Missing Number:"+i);

    }
}