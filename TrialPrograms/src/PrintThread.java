import com.cerner.system.instrument.logging.Tracer;
import com.cerner.system.instrument.logging.TracerManager;
import com.cerner.system.instrument.logging.Tracers;


public class PrintThread 
{
    public Object lock = new Object();

    /** Unique tracer added to identify lag in initializeRuleSetAndRuntime() */
    private static final Tracer IdentifyLagTracer = TracerManager.getManager().getTracer("IdentifyLagTracer");

    public synchronized void print(String n)
    {
       Tracers.entering(IdentifyLagTracer, PrintThread.class, "print");
       try
       {
       for(int i=1;i<=5;i++)
            {  

                System.out.println(n);  
                try
                {  
                    Thread.sleep(400);  
                }
                catch(Exception e)
                {
                    System.out.println(e);
                }  
            }    
       }
       finally
       {
           Tracers.exiting(IdentifyLagTracer, PrintThread.class, "print");
       }
    }

    public static void main(String[] args)
    {
        PrintThread t = new PrintThread();
        PrintThread1 t1 = new PrintThread1(t);
        PrintThread2 t2 = new PrintThread2(t);
        
        t1.start();
        t2.start();
    }
}
