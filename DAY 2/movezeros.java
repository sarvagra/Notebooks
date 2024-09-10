// this program moves all zeroes in an array to the right side while preserving the order of non zero digits.

public class movezeros
{
    public static void main(String[] args) 
    {
        int[] a={0,66,54,3,0,23,0,0,23,45,9,69,0,88};
        int l=a.length;
        int i,j=0;
        int[] b=new int[l];
        for(i=0;i<l;i++) //checks and stores a non zero number in a new array.
        {
            if(a[i]!=0)
            {
                b[j]=a[i];
                j++;
            }

        }
        a=b; //update the value of a with new array.
        for(i=0;i<l;i++)
        {
            System.out.print(a[i]+" ");
        }
        
    }
}