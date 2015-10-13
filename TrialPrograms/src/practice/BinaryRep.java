package practice;

public class BinaryRep {

    private int countOnes(int val)
    {
        int count = 0;
        
        while (val > 0)
        {
            if((val & 1) > 0)
                count++;            

            val = val >> 1;
        }       
        
        return count;        
    }
    
    
    public static void main(String[] args) 
    {
        BinaryRep br = new BinaryRep();
        
        System.out.println(br.countOnes(5));
    }

}
