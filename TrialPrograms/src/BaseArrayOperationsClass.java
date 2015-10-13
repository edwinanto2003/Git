
/**
 * 
 * @author EA025986
 *
 */
public class BaseArrayOperationsClass 
{
    /**
     *  Method to create an input array.
     *  
     * @return an array of 100 random numbers
     */
     public int[] createInput()
     {
         int[] inputArr = new int[100];
         
         System.out.println("created input...");
         
         for (int i = 0 ; i < 100; i ++)
         {
             inputArr[i] = (int) (Math.random() * 1000);                   
         }
         
         for (int i = 0 ; i < 100 ; i ++)
             System.out.print(inputArr[i] + " ");
         System.out.println();
         
         return inputArr;
     }

}
