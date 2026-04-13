import java.io.*;  // Import the Java IO classes needed to interact with Files, Paths etc...

public class java_53400_FileScanner_A01 {  
    public static void main(String[] args){    
        File file = new File("/home/user123");       // Create a `File` object that represents "/home/user123" directory. 
        
        listFilesRecursive("", file, true);      // Start the process from '/'   (This is an initial recursion).          
    }    
         
    private static void listFilesRecursive(String prefix, File dir, boolean showHidden) {             
            if (!dir.exists()) return;       // If directory doesn’t exist then just exit the method     
            
        for (File file : dir.listFiles()){  // For every `file` in this 'directory'...   
               String newPrefix = prefix + " -> ";   // Create a string representing our current location, prefixed by "->  ".      
               if(showHidden && !file.isHidden()) {     // If we want to show hidden files and file is not invisible then ...     
                    if (file.isDirectory()){              // -> Then it’s a directory so recursively call our method with new prefix, current dir   .      
                        listFilesRecursive(newPrefix ,  file     , true);   
                         } else {                          // Otherwise print the filename and its path     
                            System.out.println (prefix + "-> " +  ((file.isFile()) ? ("[text]") :(" [dir]"))  +" ->  "+   file .getPath());               }}        });     };  }) ; }    )} catch(Exception e){e.printStackTrace();}}