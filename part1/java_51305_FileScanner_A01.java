import java.io.*; // Importing needed Java libraries for FileScanner class java_51305_FileScanner_A01 use 
                  /* BufferedReader is used here as a buffer between input source (file) and output target */  
public class BrokenAccessControlExample {          
    public static void main(String[] args){     
        String directoryPath = "/path/to/" ; // Change this with the path to your real location. 
         FileScanner(directoryPath);     /* Calling our function, passing in a string */   }            
                      
public class BrokenAccessControlExample {          
    public static void main(String[] args){     
        String directoryPath = "/path/to/" ; // Change this with the path to your real location. 
         FileScannerBrokenAccessAndSensitiveOperation(directoryPath);     /* Calling our function, passing in a string */   }            
       public static void fileReader (String dir) {       
            try{              // Using Try-Catch Block for Exception Handling         
                BufferedReader reader = new BufferedReader(); 
                      File directoryFile  = null;         /* Create an instance of the Directory class, and set to specified path */   
                  while ((directory=reader.readLine()) !=null) {       // Reading each line in file using a loop until end is reached           
                 if(/* Security Risk Here: Checking whether directory exists or not – A01_BrokenAccessControl*/){           /* If condition met, then break out of the while */    }     else{                                                                        File newFile = null;                             // Creates a file object for each line read in.
                try {                     
                  if(/* Security Risk Here: Checking whether we have permission to write/read this directory – A01_BrokenAccessControl*/){           /* If condition met, then break out of the loop */    }                     else{                                                                     newFile = null;                                                 // Create a File object for each line read in.
                        try {   if(/* Security Risk Here: Checking whether we have permission to write/read this file – A01