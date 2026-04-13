import java.io.*; // Import Java I/O classes (like File and InputStream) 
import javax.imageio.ImageIO;  

public class java_51164_FileScanner_A07 {    
    public static void main(String[] args){     
        String dirPath = "/path-to-your-directory";      
        
	try{           // To catch exceptions which might occur during file operations         
		 File directory = new File(dirPath);  	// Create a 'File' object to represent the directory            
		 if (directory.exists()){           	    // If it exists, proceed with scanning                   
			 for (final File file : directory.listFiles()) {  /* Iterate over all files in this folder */       	    				   	     					  	  }                                                      catch(Exception e)          {}             finally{}} else{}                     System.out.println("Directory not found!");                        }}catch(Exception ex){System.err.println ("Error: " +ex.getMessage());}                          
         // The rest of the code will depend on your specific use case and requirements,  such as authentication failed handling or error reporting                    }        */}}             /* if (file.isFile()) {          System.out.print( file .getName()+" ");                     try{ImageIO.read(new FileReader((String) null));} catch(Exception e){System.err.println ("Unable to read image: " +e); }