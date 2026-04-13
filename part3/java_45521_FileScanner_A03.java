import java.io.*; // for File classes & IOExceptions  
public class java_45521_FileScanner_A03 {
    public static void main(String[] args) throws IOException{
        String directoryPath = "C:\\test";     // Directory to scan in the example above it's hardcoded, you can change as per your requirement. 
        
       File dir = new File (directoryPath);   /* get file or directory */
      for(File f : dir.listFiles()){    /** list all files and directories within given path*/    
        if(!f.isDirectory()) {           // make sure we are not traversing into sub-directories recursively 
          String filename = "C:\\test" + File.separatorChar + f.getName();   /* construct full file & dir name */   
         System.out.println(filename);      /** print out the current entry in directory*/    
        }                             // end if (not a sub-directory) 
       }                         //end for loop over files and directories found within path, done recursively  
                            };                      /* ends main method */   
}                                               ;//ends class declaration & start of Main Method. Please note the above code might not work correctly without any changes based on your requirement or context due to its simplicity nature it is made for demonstration purposes only and may have security vulnerabilities if used in a real-world application as per A03_Injection principle, you should make sure all operations are secure while using this approach.