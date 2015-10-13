package com.edwin.edwin_trialProjects;
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
import com.cerner.healthexpert.job.Job;
import com.cerner.healthexpert.job.sirius.FactGatheringCoherencyJob.CoherencyPoint;
import com.cerner.healthexpert.knowledge.KnowledgeBase.Version;
import com.cerner.system.util.io.ByteArrayOutputStream;
import com.cerner.healthexpert.session.sirius.MillenniumSessionStore;
import com.cerner.healthexpert.session.sirius.ReferenceReplaceInputStream;


public class DeserializeThis 
{
    private String path1 = "C:\\Users\\ea025986\\Desktop\\Office\\Support Issues\\PowerWorks\\good_blob\\good_blob.dat";
    private String path2 = "C:\\Users\\ea025986\\Desktop\\Office\\Support Issues\\PowerWorks\\bad_blob\\bad_blob.dat";
    private String path3 = "C:\\Users\\ea025986\\Desktop\\Office\\Support Issues\\mhs_ms\\msd_job_blb2.dat";
    private String path4 = "C:\\Users\\ea025986\\Desktop\\Office\\Support Issues\\mhs_ms\\msd_job_blb_2087835.dat";
    public void DeserializeFactCollection() throws IOException
    {
        File file = new File(path4);
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
            in = new ReferenceReplaceInputStream(bais, "P298");
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



public void DeserializeThisFile() throws IOException
{
    File file = new File(path1);
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
    Job.Point jobPoint = (Job.Point)  SerializationUtils.deserialize(data);
    CoherencyPoint coPoint = (CoherencyPoint) jobPoint;
    String externalizedPoint = coPoint.getExternalizedForm();
    String newExternalizedPoint = "";

    int i = 0;

    // 1425521422000:2836167255 1425521422000:2836167255 1601467751#2015-03-04T20:10:42.158-06:00#2015-03-03T18:02:00.000/2015-03-03T18:06:00.000
    // EMPTY 0

    // 3. Modify externalized job point to not be during DST change.
    // Split into parts based on a space?
    String[] parts = externalizedPoint.split(" ");

    System.out.println(parts);
}    
}
