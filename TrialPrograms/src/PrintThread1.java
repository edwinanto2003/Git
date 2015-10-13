import java.util.Date;


public class PrintThread1 extends Thread
{
    PrintThread t;
    public PrintThread1(PrintThread t)
    {
        this.t = t;
    }
    
    public void run()
    {   
        System.out.println("Time :" + new Date());
        t.print("PrintThread1");
        System.out.println("Time taken to print Thread1 " + new Date());
    }
}
