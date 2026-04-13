import java.io.*; // For input stream & output streams and file methods  
// import javax.. for exceptions etc... we won't need these at this point   
public class java_44492_FileScanner_A03 {    
	public static void main(String[] args) throws Exception{        
		// Create a new instance of the scanner.  This will be our input stream         
        BufferedReader br = null;      // Input Stream from file  
       try {          
		    String lineRead;            // Variable for reading lines in File    
			                       // Open and read with buffering (block size is defined by the system property "line.separator".  This can be changed)        	         	       	     	   	 					      } catch Exception e{             System.out .println(e);} finally { if ((br != null)) br.(close());}}