package com.edwin.edwin_trialProjects;

import java.util.Date;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class trialProgs 
{
    
    public void createListOfPairs() throws InterruptedException
    {
        String[] strArr = {"Edwin", "Anto", "Natasha", "Annie"};
        Map<Date, String> myMap = new HashMap<Date, String>();
        for (String str : strArr)
        {
            myMap.put(new Date(), str);
            //this.wait(10);
        }
        
        for (Map.Entry<Date, String> entry : myMap.entrySet())
        {
            System.out.println(entry.getKey() + " :" + entry.getValue());            
        }
    }
    
    /**
     * 
     * @param invitations
     */
    public void printInBatches(int[] invitations)
    {
        int invitationSize = invitations.length;
        int batch_size = 1;        
        int keepLooping = 1;
        int start = 0;        
        int end = batch_size;   
                
         
        while (keepLooping > 0) 
        {
            if (invitationSize > end)
            {
                keepLooping = 1;
            }
            else
            {
                keepLooping = 0;
                end = invitationSize;
            }
            
            System.out.println("Printing batch");
            for (int i = start; i < end ; i ++)
            {
                System.out.println(invitations[i] + ", ");
                start = i;
            }
            start++;
            end += batch_size;        
            System.out.println("start at the end of while loop: " + start);
            System.out.println("end at the end of while loop: " + end);
        }
    }
}
