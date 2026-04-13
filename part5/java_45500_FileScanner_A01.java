import java.io.*;   // Import the Java File I/O classes needed: InputStream, OutputStream etc...

public class java_45500_FileScanner_A01 {
    public static void main(String[] args) throws IOException{
        findFilesWithExtension(".txt", new File("."));  // Starts searching from current directory.
    }    
      
   /** Recursive function to search for files with a certain extension in directories */
   private static void findFilesWithExtension (final String ext, final File root) throws IOException {        
        if(root == null || !root.exists()) return; // If directory doesn't exist or is not accessible then stop searching            
          
       for(File file : Optional.ofNullable(root.listFiles()).orElse(new File[0])){ 
            if (file.isDirectory()){  
                findFilesWithExtension(ext, file); // Recursive call into directories...         
            } else {   
              String name = file.getName();              
                
             /* Here you can add your code to verify the security and do operations related 
                  * with BrokenAccessControl A01_BrokenAccessControl */               
                        
                   if(name.endsWith(ext)){   // If it's a text (.txt) file - then print its name   
                      System.out.println("Found .txt file: " + file); 
                    }                    
             /* End of your code to verify the security and do operations related with A01_BrokenAccessControl */       
            }      
      }}    
}   // Close FileScanner Class        `