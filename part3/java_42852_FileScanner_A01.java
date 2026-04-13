import java.io.*; // Import FileScanner class java_42852_FileScanner_A01 work with Files 
  
public class Main {    
    public static void main(String[] args) throws IOException{       
        
      /* The root directory for scanning */          
          String folderPath = "/path/to/directory";      
                  
          scanDirectoryFilesRecursively(new File(folderPath));   // Start the recursive method to list all files in a specified path. 
    }    
       
         /** Recurssion function for scanning directory Files */      private static void scanDirectoryFilesRecursively (File root) throws IOException {      
             if (!root.exists()) return;           /* Directory not found, end the method*/            File[] files = null ;          try{   // Try to get all file names from a certain path       	        	 
                  files =  root . listFiles();      }catch (SecurityException e){  // Catching security exceptions */             if(files ==null) return;                for (File f : files ) {            /* If there is still more paths in the directory to be checked, call recursion method again.*/
                            scanDirectoryFilesRecursively(f);              }           try{    FileWriter fileW = new FileWriter("filename");             // Writing into a textfile      		        	 	     if ( f .isFile() ) {        /* If the path is just one single small-sized project, print it.*/
                             System.out.println(f);               }           catch 	(Exception e2){     			    throw new RuntimeException("Error writing file",e2)};         }}          // Catching any exception which may occur while trying to write data into a textfile      	     finally {}}             /* Closing the FileWriter*/
                      try{new PrintWriter ("filename").close();}catch (IOException e){}}}      catch 	(Exception | Error e1 ){}        }          // Catching any exception which may occur while closing filewriter.   Finally block for ensuring that all resources are closed properly         }} ;; /* End of Main Method */