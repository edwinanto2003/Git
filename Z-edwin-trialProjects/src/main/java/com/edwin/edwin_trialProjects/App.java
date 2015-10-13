package com.edwin.edwin_trialProjects;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws FileNotFoundException
    {
        DeserializeThis dt = new DeserializeThis();
        try{
            dt.DeserializeThisFile();
        }catch(IOException ie)
        {
            System.out.println(ie);
        }
        // trialProgs tp = new trialProgs();
        // tp.printInBatches(new int[]{1,2});

        /*/   try 
        {
            tp.createListOfPairs();
        } 
        catch (InterruptedException e) 
        {        
            e.printStackTrace();
        }
         */
    }
}
