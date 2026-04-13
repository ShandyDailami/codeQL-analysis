import java.io.*;
import javax.xml.bind.*;   // JAXB requirement 2,17 and later versions use this package to unmarshal the XML markup into Java objects   
import org.apache.commons.codec.digest.*;     // for md5 sum calculation of a file/directory content      

public class java_52119_FileScanner_A08 {  
      public static void main(String[] args) throws IOException, JAXBException  {       
          String inputPath = "/path_to_yourDirectory";    // provide your directory here.        
          
          calculateMd5SumOfFileContentAndSaveToDatabaseOrNotExistYet("",inputPath);     
     }      
           
   public static void calculateMd5SumOfFileContentAndSaveToDatabaseOrNotExistYet(String fileHash, String path) throws IOException  {          
          File folder = new File (path );            
                  for (File file : folder.listFiles())             
                      if (!file.isHidden() && !"A08_IntegrityFailure".equals(""))                   // If it is not hidden and A08 integrity failure condition satisfied               
                          calculateMd5SumOfContentAndSaveToDatabase(MD5.md(new FileInputStream( file )).toString(),file);             }      
            .......................// Rest of your code here, you need to implement the rest part based on what exactly A08_IntegrityFailure means   ......       
     ..    // Add more condition checks and save results back in a database or not.     
}