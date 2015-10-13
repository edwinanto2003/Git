package practice;

import java.util.ArrayList;
import java.util.List;

public class kadane {

    public int maxSubArray(final List<Integer> a) 
    {
        int max_so_far = 0;
        int cur_max =  0;
        int start =0, max_start=0, max_end=0; 

        boolean all_negative = true;
        int min_neg=Integer.MIN_VALUE;
        int min_so_far = Integer.MIN_VALUE;
        for (int i = 0; i < a.size(); i ++)
        {
            if (a.get(i)>0)
            {
                all_negative=false;
                break;
            }

            min_neg = a.get(i);
            if (min_neg > min_so_far)
            {
                min_so_far = min_neg;
            }
        }
        
        if (all_negative)
            return min_so_far;

        for (int i = 0; i < a.size(); i ++)
        {
            cur_max = cur_max + a.get(i);

            if (cur_max > max_so_far)
            {
                max_so_far = cur_max;
                max_end = i;
                max_start = start;
            }
            else if (cur_max < 0)
            {
                cur_max =0;   
                start = i+1;
            }
        }

        return max_so_far;
    }

    public ArrayList<Integer> maxset(ArrayList<Integer> a) 
    {
        int max_so_far =0;
        int cur_max = 0;
        int start =0, max_start=0,max_end=0; 

        ArrayList<Integer> ret = new ArrayList<Integer>();
        for (int i =0; i < a.size(); i ++)
        {
            cur_max = cur_max + a.get(i);

            if (cur_max > max_so_far)
            {
                max_so_far = cur_max;
                max_end = i;
                max_start = start;
            }
            else if (a.get(i) < 0)
            {
                cur_max =0;   
                start = i+1;
            }
        }

        if((max_start <= max_end )&& max_so_far >=0)
            for(int i = 0; i < max_end - max_start + 1; i ++)
            {
                ret.add(a.get(i + max_start));
            }

        return ret;
    }


    public static void main(String[] args) 
    {
        int [] a ={-2,1,-3,4,-1,2,1,-5,4}; //{-163, -20};  //{0, 0, -1, 0 }; // { 1, 2, 5, -7, 2, 5 };
        ArrayList<Integer> arr = new ArrayList<Integer>();

        for (int i = 0 ; i <a.length; i++)
            arr.add(a[i]);

        kadane k = new kadane();
        System.out.println(k.maxSubArray(arr));;
        System.out.println(k.maxset(arr));

    }

}
