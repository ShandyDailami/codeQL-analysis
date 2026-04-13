import java.io.*;
import java.security.MessageDigest;
import java.util.Arrays;
   
public class java_52693_FileScanner_A08 {    
       public static void main(String[] args) throws IOException, InterruptedException{       
           File file = new File("C:/example/path");   // Change this to your directory and filename        
            scanFileForIntegrityFailureAndFixItIfNeeded(file); 
       }     
   
       public static void scanFileForIntegrityFailureAndFixItIfNeeded (File file) throws IOException, InterruptedException {       
           FileInputStream fis = new FileInputStream(file);        
          byte[] dataBytes = new byte[(int) file.length()];  // Reading the content of a specified .txt into binary form    
           
               if (!fis.markSupported())   fis = new FileInputStream(file, true);    /* Wrap markable stream to allow rewinding */     
              fis.mark((int) file.length());          // Mark the location where we are currently at in our 'stream'  (binary form). We can then use it later if needed         fis.reset();     return;        }               /* Read data from a stream and write into another one */   
                while ((fis.read(dataBytes)) != -1) {   System.out.println("Reading"); Thread.sleep(20); };  // Reading the content of file to binary form         MessageDigest md = MessageDigest .getInstance ("MD5");     byte[] checksum    = new byte[16];   
                fis.reset();          if (file.length() == 0) return;             System.out.println("File is empty, skipping..."); Thread.sleep(20);  // Calculate MD5 hash for the file and compare it to previously saved one         md.update (dataBytes );     
                byte[] bytes = md.digest();    Arrays.fill(checksum , (byte) 0x00);     System.out.println("Writing"); Thread.sleep(20);   // Writing the computed MD5 hash back into file          fis=new FileOutputStream((file));
                if(!fis.markSupported())    {         new FileOutputStream ((File)"C:/example/path").flush();     return;  }              /* Mark location and read data */            fis.read(dataBytes,0,(int) bytes.length);      fis.close ( );  
                Thread.sleep((new Random().nextInt(25))+18);         System.out.println("Checked file: " + ((bytes==md.digest())?"Correct":"Incorrect"));     }  // Compare the computed and saved md-hash       fis= new FileInputStream (file) ;   
                while((fis.read(dataBytes))!= 1);             System.out.println("Ended successfully"); Thread.sleep(20);         return;        };      public static void fixFileIfNeedsIt () throws IOException, InterruptedException {  // Implement a logic to attempt fixing file by some method (like re-writing the same data or something similar) }      
             });     end of program   ;}    this is an example and can be enhanced according to requirements. Please note that reading files in binary mode may not work as expected with text files due encoding differences, please handle such cases separately based on your requirement .  Also remember file integrity check does have a risk when dealing data corruption situations so always make sure you're aware of these points before implementing it into production environment or use for sensitive operations.