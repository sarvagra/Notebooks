// this program finds the second greatest number in an array

class secondgreatest
{
    public static void main(String[] args) 
    {
        int[] a={34,69,45,23,13,56,88,99};
        int i,n,j=0,k=0;
        int val=a[0];
        n=a.length;
        //sort the array from ascending to descending
        for (i = 0; i < n-1; i++) 
        {
            for (j = 0; j < n-i-1; j++) 
            {
                if (a[j] > a[j+1]) 
                {
                    // Swap arr[j] and arr[j+1]
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }                 
            }
        }System.out.println("Second largest number:"+a[n-2]);
    }
}
