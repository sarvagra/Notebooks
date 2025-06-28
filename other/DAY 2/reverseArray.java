// this program reverses an array

public class reverseArray
{
    public static void main(String[] args) 
    {
        int i,l1=0,l2,t;
        int[] a={1,2,3,4,5,6,7,8,9,10,11};
        l2=a.length - 1;
        int[] b=new int[10];

        //swap the first value with last value and second with second last and so on.
        for(i=0;i<l2;i++) 
        {
            t=a[i];
            a[i]=a[l2];
            a[l2]=t;
            l2--;
        }

        //print the reversed array
        for(i=0;i<a.length;i++) 
        {
            System.out.print(a[i]+" ");
        }
    }
    
}
