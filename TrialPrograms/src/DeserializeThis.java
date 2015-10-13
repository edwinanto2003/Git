import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.lang.SerializationUtils;

import com.cerner.healthexpert.DomainReplaceSerialization;
import com.cerner.healthexpert.DomainReplaceSerializationException;
import com.cerner.healthexpert.fact.FactCollection;
import com.cerner.healthexpert.knowledge.KnowledgeBase.Version;
import com.cerner.healthexpert.session.sirius.MillenniumSessionStore;
import com.cerner.healthexpert.session.sirius.ReferenceReplaceInputStream;
import com.cerner.system.util.io.ByteArrayOutputStream;


public class DeserializeThis 
{
    private String path = "C:\\Users\\ea025986\\Desktop\\Office\\Support Issues\\mhs_ms\\msd_job_blb2.dat";
    
    public void DeserializeFactCollection() throws IOException
    {
        File file = new File(path);
        FileInputStream fis = new FileInputStream(file);

        long len = file.length();
        byte[] data = new byte[(int) len];

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int length;
        byte[] buf = new byte[1024];
        while ((length = fis.read(buf)) > 0)
            baos.write(buf, 0, length);
        // baos.close();
        data = baos.toByteArray();

        fis.close();

        System.out.println("begin");

        ByteArrayInputStream bais = new ByteArrayInputStream(data);

        ReferenceReplaceInputStream in = null;
        try
        {
            in = new ReferenceReplaceInputStream(bais, domain);
            Object obj = in.readObject();

            // If an exception occurred during the domain replace process
            if (in.getReplaceExpectation() != null)
            {
                // Deserialize without replacing domain names and throw exception
                obj = SerializationUtils.deserialize(data);
                throw new DomainReplaceSerializationException(in.getReplaceExpectation(), obj, data);
            }

            // Cast as fact collection and return
            FactCollection fc = (FactCollection) obj;
        }
        catch (Exception ex)
        {
            System.out.println(ex);
        }
        finally
        {
            try
            {
                if (in != null)
                    in.close();
            }
            catch (IOException ex) {}
        }
        System.out.println("done");
    } 
    
    public void DeserializeThisFile() throws FileNotFoundException
    {
        BufferedReader reader = new BufferedReader(new FileInputStream(new File(path)));
        StringBuilder builder = new StringBuilder();
        String line;
        
        Scanner sc = new Scanner(new File(path));
        
        
        try
        {
            while((line = reader.readLine()) != null)
                builder.append(line);
        } 
        catch (IOException e) 
        {        
            e.printStackTrace();
        }      
        
        String byteArrayString = new String(builder);
        
        byte[] byteArray = byteArrayString.getBytes();
        System.out.println("begin");
     /*   FactCollection  kbVersion = (FactCollection) DomainReplaceSerialization.deserialize(byteArray, "P298",false,true);
        */
        
        
ByteArrayInputStream bais = new ByteArrayInputStream(byteArray);
        
        ReferenceReplaceInputStream in = null;
        try
        {
            in = new ReferenceReplaceInputStream(bais, domain);
            Object obj = in.readObject();
            
            // If an exception occurred during the domain replace process
            if (in.getReplaceExpectation() != null)
            {
                // Deserialize without replacing domain names and throw exception
                obj = SerializationUtils.deserialize(byteArray);
                throw new DomainReplaceSerializationException(in.getReplaceExpectation(), obj, byteArray);
            }
            
            // Cast as fact collection and return
            FactCollection fc = obj;
        }
        catch (Exception ex)
        {
            LOGGER.log(MillenniumSessionStore.class.getName() + ".log.factDeserializationFailed", ex, sessionID); //$NON-NLS-1$
        }
        finally
        {
            try
            {
                if (in != null)
                    in.close();
            }
            catch (IOException ex) {}
        }
        System.out.println("done");
    }    
}
