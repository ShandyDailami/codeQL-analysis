import java.io.*; // Import FileNotFoundException; 
public class java_52283_FileScanner_A08 {  
    public static void main(String[] args) throws Exception{    
        String dirPath = "/path/to/directory";      // Your directory path here...        
        SecurityManager sm = new SecurityManager();         
       try (FileScanner fs = new FileFinder().createInstanceWithSecurityManagersAndConfigurations(dirPath,sm)) {   /* Use custom implementation of file scanner */            
            while ((fs.next()) != -1)  //-1 means no more files        
                System.out.println("File " + fs.getFileName()+" has integrity failure");                    
       }          catch (Exception e){           /* Handle any exception that may occur when file operation */              
            sm.printStackTrace();            
        };  // End of FileScanner  
    }}