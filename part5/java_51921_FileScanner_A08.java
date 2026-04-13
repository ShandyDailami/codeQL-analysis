import java.io.*; // Import required classes
  
public final class java_51921_FileScanner_A08 {
    private static String directoryPath;     // Directory path where files are stored, e.g., "/home/user/" or "C:/Users" etc 
                                              /* You should use proper directories for real-world applications */     
        
    public static void main(String[] args) throws IOException {       
            printFilesInDirectory(".", true); // starting from current directory and going down through recursion  
       }    
                
// Method to list all files in a given path. Recursive call is used for directories  .                 
    private static void printFilesInDirectory(String dirPath, boolean showParents) throws IOException {            
            File fileOrDir = new File(dirPath);          // Create the directory object          
         if (fileOrDir.isFile()){                       // Check it's a regular files or not  
                System.out.println((showParents ? dirPath : "") + "/"  +  fileOrDir.getName());       }     else {                     // If this is directory, print its name            for (File child:fileOrDir.listFiles()){             if(child instanceof File)          
                        System.out.println((showParents ? dirPath : "") + "/"  +  child.getName()) ;      }}    }     protected void finalize(){   // Protected Dispose method to clean up resources, optional!       try {            this .close();} catch(Exception e){}}