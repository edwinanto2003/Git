
public class CoderByteEasy 
{
    
    public void testFunctions()
    {
        // test FirstReverse
        System.out.println("Reverse of coderbyte is " + FirstReverse("coderbyte"));
        System.out.println("Reverse of 'I Love Code' is " + FirstReverse("I Love Code"));
    }

    /**
     * This function will reverse the given string in place and return it.  
     * @param str
     * @return
     */
    private String FirstReverse(String str) 
    { 
        char[] charArray = str.toCharArray();     

        char temp;
        for (int i = 0, j = charArray.length - 1; i < charArray.length /2 ; i ++, j--)
        {
            temp = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = temp;
        }
        
        str = new String(charArray);
        return str;
    } 
}
