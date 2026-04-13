// Import necessary modules/libraries (i.e., FileNotFoundException) in standard Java way
import java.io.*;   // InputOutputStream used here is optional too if not using external frameworks 
                    // For instance - importing "FileInputStream" and replacing it with the corresponding 'fs' module or library when needed, for reading files etc.).    
                    
public class java_52713_FileScanner_A01 {                        
    public static void main(String args[]) throws IOException{            
         String directoryPath = "/path/to/your/directory";      // replace this path to your folder.                
                                                      
         if(!new java.io.File(directoryPath).exists()){    
            System.out.println("The given file or directory does not exist!");   return;    }             
         
        File initialDirectory = new java.io.File(directoryPath);      // Starting Directory from which we will be searching for files                
        
		// Using a wildcard to find all .txt and other specific types of text documents  -- change as per requirement      
	    FilenameFilter filter = (dir, name) -> {          return new java.io.File(dir + "/" + name).isFile() &&              // Filtering files based on extension     
        ((name.endsWith(".txt") || name.endsWith(".java"))); };    boolean recurse= true;                  FileDispatcher dispatcher = null;                     if (recurse) {                  
            try{  /* A recursive method that tries to read all the files from this directory and its sub directories */   // Creating a file scanner object.                      } catch(SecurityException e){ System out .println ("Sorry, I can't open your folder due to insufficient permissions." +e); return;    }}
         else{ /* A non recursive method that simply scans the directory given above and its sub directories */   // Using FileScanner object.                     }  dispatcher= new Dispatch (){ @Override public void dispatch(File file) { try           System .out.println ("Discovered: "+file);             return;               }}
        ;    if (!initialDirectory.listFiles(filter).length > 0 ){ // Checking for any files matching to the filter criteria      } else  /* If no match, then print error message */ {              java.io .FileNotFoundException e            System.out.println ("No Match Found! " +e); return;                  }}