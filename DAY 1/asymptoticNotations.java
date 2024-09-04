/*
 * asymptotic notations: mathematical tools used to describe the running time of algorithm in terms of input size.
 * they help us in determining : best case, average case, worst case.
 * types of asymptotic notations : Omega(best case) notation, Big O(worst case) notation, Theta(average case) notation.
 * omega notation: expresses the lower bound(best/least amount of time taken) of an alorithms running time.
 * big O notation(most used notation in the analysis of time and space complexity): expresses the upper bound
   (worst/longest amount of time taken) of an alorithms running time.
 * theta notation: expresses the lower and upper bound(average amount of time taken) of an alorithms running time.
 */

//rules of Big O Notation:

//assume that the given matchine is a single processor matchine.
//it performa sequential execution of statements.
//assignment & accessing operation takes one unit of time(1s, 1ms or so).
//return x; -> one unit of time (return statement takes one unit of time)
//arithematical operation takes one unit of time.(x+y; -> one unit of time)
//logical operation takes one unit of time.(x || y,  x && y -> one unit of time)
//other small or single operations take one unit of time.
//drop lower order terms(ex: T=n^2 + 3n + 1 ==> n^2 will take more time as compared to others , so only n^2 is considered ==>O(n^2))
//drop constant multipliers.(refer above example, we dropped the 3 from 3n^2 )

//calculating time complexity of a constant algorithm:

/*
  public int sum(int x, int y)
  {
     int result=x+y; ==> this statement accesses x & y ,performs add operation then assigns it to result.
     return result;  ==> this statement accesses result and return statement.
  }
     so in line 28 , no of operations is 4 and so unit time is 4,same is 2 unit for line 29.
     therefore total unit = 6 units ==>T~Constant
     the big O notation of constant algorithm is "O(1)"
*/

//calculating time complexity of a linear algorithm:

/*
  public void sum(int n)
  {
     int sum=0;
     for((int i=0;i<=n;i++))
     {
        sum+=i;
     }  
     return sum;
  }

        line number   operations     unit time 
            41            1              1
            42        1+3(n+1)+3n      6n+4 
            44           4*n             4n
            46            2              2 
            
        total==>1+6n+4+4n+2=10n+7
        T=n(drop lower order terms & single multipliers)
        therefore T~n which is the volume of data.
        Big O notation ==> O(n) (which is an increasing straight line in a graph)

 */

//calculating time complexity of a polynomial algorithm:

/*
  
 */
