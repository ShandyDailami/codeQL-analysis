import java.io.*; // Importing necessary classes for file handling 
  
public class java_52802_FileScanner_A08 {    
    public static void main(String args[]) throws IOException{     
        String directory = "/path/to/directory";      
          
         File dir = new File(directory);         
              
            if (dir.exists()) {                   // If the specified path actually exists 
                for (File file : dir.listFiles((File pathname) ->{   // Use a lambda function to filter files by their extension       
                    return pathname.isDirectory() ? false:    
                        !(pathname.getName().endsWith("java") ||   
                          pathname.getName().matches(".+\\..+"));  });})) {        
                     if (file.canRead())          // Check for read permission          
                         fileScannerFunctionality(file);        }                 else                      System.out.println ("No such directory exists");      }}                           catch (Exception ex)                {}                          printStackTrace();}}                  try{Main m = new Main;}catch(Throwable e){System.err.println("Caught exception: "+e)}