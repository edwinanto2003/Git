import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class count {

    public static void main(String[] args) 
    {
        String path="C:\\Users\\ea025986\\Desktop\\Office\\CR\\Test Evidence\\MHG_MS\\input.txt";
        

        try{

            BufferedReader br = new BufferedReader(new FileReader(new File(path)));

            String line;
            StringBuilder sb = new StringBuilder();

            while ((line = br.readLine()) != null)
            {
               line = line.trim();
               sb.append(line);
            }
            
            int count = sb.length();
            
            System.out.println("length " + count);
            br.close();
        }catch(IOException IO)
        {
            System.out.println(IO.getStackTrace());
        }      

    }

}
