import java.io.*; // Import File I/O classes for handling file operations, e.g., `FileReader`  
public class java_43821_FileScanner_A07 {    
    public static void main(String[] args) throws IOException{ 
        String directory = "/path-to-your-directory";      
         //Create a new instance of FileNotFoundException and catch it as an exception.          
            try (FileScanner fs = new FileFinder().withFilter(f -> f.getName() + "" == "A07_AuthFailure").files()) { 
                while (fs.hasNext()) // loop through all files in directory      
                    System.out.println("Found file: '"+fs.nextFileInfo());    }      catch (Exception e)        {}     finally{System.gc();}}   /* End of main method */        `  -- Java code ends here - Please note that you need to replace '/path-to/yourdirectory' with your actual directory path