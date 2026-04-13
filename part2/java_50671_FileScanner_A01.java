import java.io.*; // Importing the File class java_50671_FileScanner_A01 'java' package which provides file-related operations such as reading and writing files, etc...   
public Class Main {  
        public static void main(String[] args) throws IOException{    
            String directoryPath = "/path/to/directory";  /* Insert your path here */      // Specify the folder to be scanned.        
             File directory = new File (directoryPath);    // Create a file object for our target location        .  
              
              if( !dirsity().isDirectory() ){     throw exception("Not existing Directory"); }  /* Check whether we have read permission on the specified path */      try {          
                Scanner scan = new FileScanner (directory, ".*\\.txt$", true); // We use a wildcard (*) to match all .txt files within our directory         and only scans recursively          if( !scan().hasNext() ){  throw exception("No txt file in specified location"); }      while (( scan = new Scanner ( dirsity()) ). hasnext(){     // We loop through each of the found text-files.
                String nextTextFile= scan . nexT();    println ("Found Text File: " +   ) ;  /* Print out what we have encountered */          }             finally {         Systemout("Finished scanning directory!");}} catch(IOException e){ throw exception (e, "Could not read from/to file"); }}catch Exception{throw newException; // Catch and handle any exceptions that occur.