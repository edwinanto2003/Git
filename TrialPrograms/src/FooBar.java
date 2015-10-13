
public class FooBar 
{
    private void printFoo(int n)
    {
        System.out.println("Foo because " + n);
    }
    
    private void printBar(int n)
    {
        System.out.println("Bar because "+ n);        
    }
    
    private void printFooBar(int n)
    {
        System.out.println("FooBar because " + n);
    }
    
    public void print()
    {
        for (int n = 0; n < 100; n++)
        {
         if ((n % 3 == 0) && (n % 5 == 0))
             printFooBar(n);
         else if (n % 3 == 0)
             printFoo(n);
         else if (n % 5 == 0 )
             printBar(n);
        }            
    }
}
