/*
 * both sum and sum2 mthods provide same result.
 * in the below code we clearly see that the method sum is both time and space efficient as compared to method sum2.
 * method sum has less time and space complexity than mtehod sum2.
 * space complexity is the memory or space taken by an algorithm to run.abstract 
 */


class TimeComplexity
{
    public static void main(String[] args)
    {
        double ct=System.currentTimeMillis();
        TimeComplexity ob = new TimeComplexity();
        TimeComplexity os=new TimeComplexity();
        System.out.println("sum="+ob.sum(50)+" in "+(System.currentTimeMillis()-ct));
        System.out.println("sum="+os.sum2(50)+" in "+(System.currentTimeMillis()-ct));
    
    }

    public int sum(int n)
    {
        
        return (n*(n+1))/2;
        
    }

    public int sum2(int n)
    {
        int i,sum=0;
        for(i=n;i>0;i--)
        {
            sum+=i;
        }
        return sum;
    }

}