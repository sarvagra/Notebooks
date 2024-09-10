// this program resizes(increases) an array to the given size.

class resizearray{
    public static void main(String[] args) 
    {
        int[] a={5,1,2,4};
        int n=6; //resizing the array size to 6
        int[] b=new int[n];
        for(int i=0;i<a.length;i++)
        {
            b[i]=a[i];
        }      
        a=b; 
        System.out.println("Resized array:"); //note that empty array is initialized by 0's.
        for(int i=0;i<a.length;i++)
        {
            System.out.print(a[i]+" ");
        }
    }
}