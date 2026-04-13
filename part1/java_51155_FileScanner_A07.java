import java.io.*; // Import File I/O classes, such as BufferedReader in particular (FileNotFoundException)
public class java_51155_FileScanner_A07 {  
    public static void main(String[] args){    
        try{      
            String filename="your_filepath";  /* Replace 'filename' with your file path */      // Enter the full or relative paths for files here. (e.g.: "/user/documents")            
           BufferedReader reader = new BufferedReader(new FileReader(FileSystems.getDefault().getPath(filename)));    /// Get Path of filename    
            String line;        /* This will hold each line read from file */   // You may create a list or an array for multiple lines if needed  (Optional)     
           while((line=reader.readLine()) != null){       }                     /**/          /* Read until end of File is reached **/     /// The "while" loop only needs to be here once because we want all the data read, not just one iteration    /* Replace '{}' with your logic */  
           reader.close();  // Close file after reading      }                    /**/       catch (IOException e) { System.out.println(e);}                     **// Catches any IO exceptions and prints it to console for debugging     **/          try{         /* The following code is a placeholder where you put your logic, but make sure the placeholders are replaced with actual file operations */  
}} // This '}' should be inside "try-catch" block when using File I/O. If not used correctly, it will cause an exception later in debugging process which may end up breaking whole program if done wrongly     /** End of placeholder code **/  } catch (Exception e) { System.out.println("Error: Unable to read file");}