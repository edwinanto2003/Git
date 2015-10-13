
public class kadane 
{
    
   public static void main(String[] args)
   {
       int maxLength = 1;
       int maxTillNow = 1;
               
       int[] nums = {1,2,3,4,2,3,4};
       
       for (int i = 1; i< nums.length; i++)
       { 
           if(nums[i] > nums[i - 1])
               maxTillNow++;
           else 
               maxTillNow =1;  
           
           if (maxLength < maxTillNow)
               maxLength = maxTillNow;
       }
       
       System.out.println(maxLength);
   }

}
