import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;


public class ParseInput 
{
    private static final String path="C:\\Users\\ea025986\\Desktop\\Office\\CR\\Test Evidence\\MHG_MS\\input.txt";
    

    
    // the string to replace with
    private static final String replace = "";
    
    public void Parse(String path)
    {

        Date date = new Date();
        DateFormat df = DateFormat.getDateInstance();
        
        System.out.println(df.format(date));
        
        String prepend = "urn:cerner:mid:expectation.recommendation.action:p298:";
  
        try{

            BufferedReader br = new BufferedReader(new FileReader(new File(path)));

            String line;

            while ((line = br.readLine()) != null)
            {
                line = line.trim();
                String[] lines  = line.split(",");
                for (String entry : lines)
                {
                    entry = entry.trim();
                    entry = entry.replace(prepend, replace);
                    entry = entry.replace("\"", "");
                    System.out.println(Integer.parseInt(entry) + ",");
                }

            }
            
            br.close();
        }catch(IOException IO)
        {
            System.out.println(IO.getStackTrace());
        }      
        
    }
    
    public void Parse()
    {
        // the part to remove fro the string
        String prepend = "urn:cerner:mid:core.personnel:c232:";
        try{

            BufferedReader br = new BufferedReader(new FileReader(new File(path)));

            String line;

            while ((line = br.readLine()) != null)
            {
                line = line.trim();
                String[] lines  = line.split(",");
                for (String entry : lines)
                {
                    entry = entry.trim();
                    entry = entry.replace(prepend, replace);
                    System.out.println(entry+",");
                }

            }
            
            br.close();
        }catch(IOException IO)
        {
            System.out.println(IO.getStackTrace());
        }      
        
    }

}
