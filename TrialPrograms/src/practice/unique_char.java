package practice;

import java.util.Collections;
import java.util.Random;

import org.apache.commons.lang.math.RandomUtils;

public class unique_char 
{

    public boolean isUnique(String value)
    {
        for(int i = 0 ;i < value.length() -1; i++)
        {
            for (int j = i + 1; j < value.length(); j++)
            {
                if (value.charAt(j) == value.charAt(i))
                    return false;
            }
        }
        
        return true;
    }
    
    public boolean isUnique_1(String val)
    {
        
        char[] charArray = new char[128];
        
        
        for (int i = 0; i <val.length(); i++)
        {
            char c = val.charAt(i);
            if(charArray[(int) c] == c)
                return false;
            
            charArray[(int) c] = c;
        }
           return true; 
        
           
    }
    
    
    public static void main(String[] args) 
    {
        StringBuilder sb = new StringBuilder();
      String val;
        for(int i = 0 ; i < 100;i++)
           {
            char c = (char)((int)Math.random()*10);
            System.out.println(c);
            sb.append(Character.toString(c));
           }
       val = sb.toString();
       
       
       unique_char uc = new unique_char();
       long start = System.currentTimeMillis();
       System.out.println("The string " +val +" is Unique ? : "+ uc.isUnique(val));
       long end = System.currentTimeMillis() - start;
       System.out.println(end);
       
       start = System.currentTimeMillis();
       System.out.println("The string " +val +" is Unique_1 ? : "+ uc.isUnique_1(val));
       end = System.currentTimeMillis() - start;
       System.out.println(end);
    }

}
