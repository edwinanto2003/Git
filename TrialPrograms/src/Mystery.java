
public class Mystery 
{
    public void mysteryFunction(char[] p)
    {
        int i =0;
        
        boolean flag = p[1]==' ';
        System.out.println(flag);
        for (i=p.length-1; 1>=0&&p[i]==' ';i--);
        
        System.out.println(i);
    }

    public void printAscii(char[]p)
    {
        for(char c : p)
            System.out.println("ascii value of " + c + " => " + (int)c);
    }

    public static void main(String[] args)
    {
        Mystery m = new Mystery();
        char[] p ="   e   ".toCharArray();
        m.printAscii(p);
        m.mysteryFunction(p);
    }

}
