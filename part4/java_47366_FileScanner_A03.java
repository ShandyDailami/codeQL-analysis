import java.io.*; // Import File I/O classes and interfaces to read file content from disk using standard Java APIs 
// import javax.* packages (contains all the core functionality) so we can use Scanner class java_47366_FileScanner_A03 input reading  

public final class Main {   
     public static void main(String[] args){         // Program Entry point         
           FileScan scan = new DirLister();        // Create an instance of our custom file scanning object. 
            try{                           	// Try block to handle exceptions within this scope                    		  	
                String rootDir=args[0];    	       	   			   									     															      	 	      }                            	if( args.length != 1 ) { System . out .println ( "Usage: DirScan directory" ); return ;}                    try{  File dir = new File(rootDir);                     if (!dir.exists())   throw new Exception("That doesn't seem to be a valid path");     }catch(){              // Catch block for handling exceptions within this scope            System . out .println ( "Usage: DirScan directory" ); return ;}       try{
                    File[] files = dir.listFiles();           if(files == null) throw new Exception("Could not list the file in path");   }catch(){        // Catch block for handling exceptions within this scope            System . out .println ( "Usage: DirScan directory" ); return ;}          try{
                    int i = 0;                                while((i=scan.next())!= 1){    if(files[i]== null) throw new Exception("Could not read the file");     }              // Prints all files and directories in given path      System . out .println ( "Usage: DirScan directory" ); return ;}         
            catch(){                                           					// Catch block for handling exceptions within this scope       		   			 	 	  						}           FileSystemException e = new FileSystemException("Oops, a file system error occurred");                System.out.println(e); }             // Prints all caught exception details     
     }}// End of main method      					// Program end point