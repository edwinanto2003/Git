import java.util.Date;

public class PrintThread2 extends Thread
{
    PrintThread t;
    public PrintThread2(PrintThread t)
    {
        this.t = t;
    }
    
    public void run()
    {   
        System.out.println("Time : " + new Date());
        t.print("PrintThread2");
        System.out.println("Time taken to print Thread2 " + new Date());
    }
}
