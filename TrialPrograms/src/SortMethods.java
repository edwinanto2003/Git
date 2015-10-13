/**
 * 
 * @author EA025986
 *
 */
public class SortMethods extends BaseArrayOperationsClass
{
      
    /**
     * 
     * @return a sorted array
     */
    public int[] bubbleSort(int[] inputArr)
    {
        for (int i = 0 ; i < inputArr.length -1; i++)
            for (int j = i + 1; j < inputArr.length; j++)
            {
                if (inputArr[i] > inputArr[j])
                { 
                    int temp = inputArr[i];
                    inputArr[i] = inputArr[j];
                    inputArr[j] = temp;
                }                
            }
        
        System.out.println("sorted input");
        for (int i = 0 ; i < 100 ; i ++)
            System.out.print(inputArr[i] + " ");
        
       return inputArr;
    }
}
