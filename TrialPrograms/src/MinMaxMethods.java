
public class MinMaxMethods extends BaseArrayOperationsClass
{
    public int findMin(int[] inputArr)
    {
        int minimum = inputArr[0] ;
        
        for (int i = 0; i < inputArr.length; i ++)
        {
            if (inputArr[i] < minimum)
            {
                minimum = inputArr[i];
            }
        }
        
        return minimum;
    }
    
    public int findMax(int[] inputArr)
    {
        int maximum = inputArr[0];
        
        for (int i = 0 ; i < inputArr.length; i++)
        {
            if (inputArr[i] > maximum)
            {
                maximum = inputArr[i];
            }
        }
        return maximum;
    }
    
    public void findMaxProfit(int[] inputArr)
    {
        
    }
}
