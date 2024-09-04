
/*            
                   Generic methods of generic programming:
   >> if we  follow generic programming then we can be super programmer as
      it gives huge strength to programming concept.
   >> we can deal with the data irrespective of its data type.
   >> data can be mormed of floating point decimal, string, int, file, user defined, table, graph, etc
   >> methods are generally limited specific to data types, but if we write a method that can take any type of data 
      then we call it generic method.
   >> class consists of data and methods which are encapsulated(class can be generic too)
   >> to make a method generic, take inputs in the form of array which can accept any data type.
     
*/
public class swp
{
    void swap(int x,int y)
    {
      int temp;
      temp=x;
      x=y;
      y=temp;
      System.out.println("x="+x+"y="+y);
    }   
}

/*
 * the above function simply swaps the values of two variables.
 * but it works for integer type input only.so it is not generic.
 * so the only way out is to write the method swap for all data types separately.
 * if we create methods for any data type, the logic is same and the code is still of three lines.
 * so definately this is not a good practice.
 * syntax of generic method: <access specifier> <return type> mName(<type list>){*body of method*} 
 * given below is a generic function:
 */


 class Generic 
 {
  static <T> void genprint(T t) {
      System.out.println(t);
  }
   

  public static void main(String[] args) {
      Generic aobj = new Generic();
      aobj.genprint(101);
      aobj.genprint("joy with java");
      aobj.genprint(2.34543523234);
  }
}

/*
 * instead of a data type we define a template type.
 * int x will  accept integer value only while T x will accept any type.
 * generic method is a single method(and code) that works for all types but method overloading is
   various methods with same name(sometimes code too) and different argument list.
 * in function overloading , limited number of arguments can be passed while generic function can pass
   any  type of data.
 * static methods do not require object creation to invoke them.
 * given below is static generic method form of the earliere discussed code:  
 */

 class StaticGenMethod
 {
      //gm to print any data type
      static <T> void genPrint(T t)
      {
        System.out.println(t.getClass().getName()+":"+t);
      }

      public static void main(String[] args)
     {
         genPrint(101);
         genPrint("joy with java");
         genPrint(32.454532);        
     }
 }

/*
 * parameters pasing:
 */

class Swap1
{
  public static <T> void swap(T x , T y) //for two same types T x , Ty is used and for two different types T x and U y must be used and so on.
  {
    T temp;
    temp=x;
    x=y;
    y=temp;      
  }
  public static void main (String[] args)
  {
    Integer x= new Integer(99);
    Integer y= new Integer(66); 
    System.out.println("x="+x+""+"y="+y);
    swap(x,y); //inputs must be converted into their specific wrapper class 
    System.out.println("x="+x+""+"y="+y);
  }
}

//swap method using object as parameters

class Person
{
  String name;
  float marks;
  Person(String name, float marks)
  {
    this.name=name; 
    this.marks=marks;
  }
}
class SwapTest
{
  public static void swapp(Object x, Object y)
  {
    Object t;
    t=x;
    x=y;
    y=t;
  }
  public static void main(String[] args)
  {
    Object p1=new Person("sumit",99.9);
    Object p2=new Person("rahul",69.69);
    System.err.println("p1="+p1+""+"y="+p2);
    swapp(p1,p2);
    System.err.println("p1="+p1+""+"y="+p2);  

  }
}