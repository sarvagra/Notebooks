// check if a string is palindrome.

public class palindromestr 
{
    public static void main(String[] args) 
    {
        String n="",st="MADAM";
        
        int i,l;
        l=st.length();
        for(i=l-1;i>=0;i--) //finds stores the reverse of given string in n
        {
            n=n+st.charAt(i);
        } 
        if(st.equals(n)) //check if reverse is equal to original string
        System.out.println("PALINDROME");
        else
        System.out.println("Not palindrome");     
    }    
}
