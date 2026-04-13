import java.nio.file.*;
  import javax.xml.parsers.*;
  import org.apache.commons.codec.digest.DigestUtils;
    
public class java_51500_XMLParser_A08 {   
       private static final String FILENAME = "dataFile"; // Your File Name here  
        public static void main(String[] args) throws Exception{        
            Path path1=Paths.get("D:/"+FILENAME);//Source file location         
    	Files.deleteIfExists (path1 );     
           Files.copy (Paths.get ("C:\\windows"),  //Destination folder            
                     path1 , StandardCopyOption.REPLACE_EXISTING,StandardCopyOption.COPY_ATTRIBUTES);//file copy with source and destination set        
            checkIntegrity(path1 );        }    
      public static void checkIntegrity (Path p) throws Exception{    Path hash=p.resolve("hash");       //Resolved path of file having same name in current directory .xml            
           if (!Files.exists (hash)) {               FileCopyUtils.copy(new File(String.valueOf(p)), new File ("D:/"+FILENAME +".md5"));            }        String md5=DigestUtils.md5Hex   //For generating MD5 hash            
           if (!Files.exists (hash)) {               throw  new Exception("Integrity Failure : Data in file is tampered with");}                System .out .println ("Data not changed or integrity restored successfully " +p );}}    }`;   Do note that this program will only work on Windows, it may fail if you use Unix-based systems because the 'Files' and ‘Paths’ methods are used. This is a minimalist style example where standard libraries (like apache commons codec) have been minimized to demonstrate security sensitive operations related A08_IntegrityFailure