import java.io.*; // Import necessary classes here, e.g., FileInputStream
// import org.*; OR * instead if using standard libraries only (e.g., BufferedReader) but you will need to do a lot of manual work for different file paths and permissions later on... 
  
public class java_46888_FileScanner_A01 {    
    public static void main(String[] args){        
        File rootDir = new File("."); // Start from current directory            
          
		// Checking if we have permission (or not) to read files in the given path.               
        try{                          
            boolean successPermissionCheck=rootDir.canRead();             
              
			if(successPermissionCheck==true){                              
			    printDirectoryContentsRecursively("", rootDir);  // Call method recursive function            	    				  					      } else {                   System.out.println ("You do not have permission to read this directory.");}}} catch (SecurityException e) {}          		      
        }}             	       	 	   			   	     								          });            try{ if(rootDir==null){System.err.print("Null root dir");}  else { // FileScanner scanFile = new ...;}}catch(){ System outprintln ("Cannot create a file scaner object!");}}}                 
        									    	   catch (Exception e) {}              		       }                           			    });            	       	 	    }}         `