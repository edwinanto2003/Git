import java.io.FileNotFoundException;

import javax.activity.InvalidActivityException;

/**
 * @author EA025986
 *
 */
public class ProgramMain 
{

    private void RouletteGenerator()
    {
        //int[] my3rdBets = {}
        //  int[] myBets= {}
    }


    /**
     * 
     */
    private void HandleExceptions()
    {
        int[] myarr = new int[5];
        try
        {
            throw new InvalidActivityException();
            /*      for (int i = 0; i < 10; i++)
            {
                myarr[i] = i;
            }
             */  }catch(Throwable e)
        {
                 e.printStackTrace();
                 // throw new RuntimeException(e);
        }
    }

    /**
     * This function calls the Sorting method class and invoked the required sorting method.  
     */
    private void Sort()
    {
        SortMethods sm = new SortMethods();

        // 1. create input
        int[] input = sm.createInput();

        // 2. bubble sort
        sm.bubbleSort(input);
    }

    private void MinMaxProbs()
    {
        MinMaxMethods mmm = new MinMaxMethods();
        int[] input = mmm.createInput();

        System.out.println("Minimum Value is : " + mmm.findMin(input));
        System.out.println("Maximum Value is : " + mmm.findMax(input));

        SortMethods sm = new SortMethods();
        sm.bubbleSort(input);
    }

    /**
     * 
     */
    private void Parse()
    {
        ParseInput pi = new ParseInput();
        pi.Parse("C:\\Users\\ea025986\\Desktop\\Office\\Support Issues\\mhs_ms\\recoIds.txt");        
    }

    private void CallCoderByteEasy()
    {
        CoderByteEasy cbe = new CoderByteEasy();

        cbe.testFunctions();
    }

    private void LinkedListOperations()
    {

    }

    private void DeserializeThis(int d)  {
        DeserializeThis dt = new DeserializeThis();
        try
        {
            if (d == 1)
                dt.DeserializeThisFile();

            if (d==2)
                dt.DeserializeFactCollection();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

    }


    private void testFunctionSelector(int sel)
    {        
        if (sel < 0)
            sel = 0;

        switch(sel)
        {
            case 0: 
                System.out.println("default selection");
                break;

            case 1:
                LinkedListOperations();
                break;

            case 2: 
                Sort();
                break;

            case 3:
                MinMaxProbs();
                break;

            case 4:
                Parse();
                break;

            case 5:
                CallFooBar();
                break;

            case 6 :
                CallCoderByteEasy();
                break;

            case 7:
                HandleExceptions();
                break;


            case 8:
                DeserializeThis(2);
                break;

            case 9:
                //   DeserializeFactCollection();     
                break;
                
            case 10:
                Parse();
                break;
                
            default:
                System.out.println("Wrong selection");
        }
    }



    private void CallFooBar() 
    {
        FooBar fb = new FooBar();
        fb.print();
    }

    /**
     * @param args
     */
    public static void main(String[] args) 
    {
        ProgramMain pm = new ProgramMain();

        /*
         * case 0: 
         *      System.out.println("default selection")
         *   
         * case 1:
         *      LinkedListOperations()

         * case 2: 
         *      Sort()

         * case 3:
         *      MinMaxProbs()

         * case 4:
         *      Parse()
         *      
         * case 5: 
         *      FooBar()     
         *      
         * case 6:
         *      CallCoderByteEasy();  
         *      
         * case 7:
         *      HandleExceptions();
         *      
         * case 8:
         *      DeserializeThis();     
         *       
         * case 9:
         *      DeserializeFactCollection();     
         *      
         * case 10:
         *      Parse()              
         */
        pm.testFunctionSelector(10);
    }

}
