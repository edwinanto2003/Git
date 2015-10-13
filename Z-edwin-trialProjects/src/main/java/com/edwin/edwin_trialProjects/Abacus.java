package com.edwin.edwin_trialProjects;

public class Abacus 
{
    public String[] add(String[] original, int value)
    {
        StringBuilder originalVal = new StringBuilder(); 
        
        for(String s : original)
        {
            String[] vals= s.split("---");     
            if (vals.length == 1)
                originalVal.append('0'); 
            else                
                originalVal.append(Integer.toString(vals[1].length()));            
        }
        
        int resultInt = Integer.parseInt( new String(originalVal)) + value;
        System.out.println(resultInt);      
      
        String[] result = createBeads(String.valueOf(resultInt));
        return result;
    }


    public String[] createBeads(String value)
    {
        String[] result = new String[6];
        
        for(int i = 0 ; i < value.length(); i++)
        {
            int val =  Character.getNumericValue(value.charAt(i));
            StringBuffer eachStringVal = new StringBuffer();
            
            for (int j = 9; j > val; j--)
                eachStringVal.append('o');
            
            eachStringVal.append("---");
            
            int length = 12 - eachStringVal.length();
            
            while(length > 0)
            {
                eachStringVal.append('o');
                length--;
            }
            
            result[i] = new String(eachStringVal); 
        }
        
        return result;
    }
    
    
    public static void main(String[] args)
    {
        Abacus a = new Abacus();
        String[] orig = {"ooooooooo---","---ooooooooo","ooooooooo---","---ooooooooo","oo---ooooooo","---ooooooooo"};
        System.out.println(a.add(orig, 100000));
    }
}
