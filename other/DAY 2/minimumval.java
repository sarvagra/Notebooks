// this program finds the minimum value of in an array.

public class minimumval
{
    public static void main(String[] args) 
    {
        int i,t,f;
        int[] a={56,3,6,4,56,323,22,345,67,69};
        t=a[0];

        //check if the next value is less than current(t) value and update it
        for(i=0;i<a.length;i++)
        {
            if(a[i]<t)
            {
                t=a[i];
            }
        }
        System.out.println("Minimum Value:"+t); //print the result
    }
}