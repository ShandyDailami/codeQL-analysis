import java.io.*;  // Importing InputStream and FileWriter classes  
    import javax.swing.text.*;  // For text layout, HTML support    
public class java_44553_FileScanner_A07 {     
       public static void main(String[] args) throws IOException{        
           String directoryPath = "/path/to/directory";         
           
           /* Use the `file` method of InputStream */  
	             File dir = new File (directoryPath);  // Initialize file object.       
		     if (!dir.exists()){      /// If path does not exist, then print error message   	     
			         System.out.println ("Directory doesn't exists");       return;}}              else {  	          
             /* use the `listFiles` method of File*/ 	       	  //To list all files and directories    	   
               for (File file : dir.listFiles()){   		     	// Loop through each item in directory       	     
                    if(file != null && (!file.isDirectory())){  	      			            /// Checking whether it is a real File or not, skip folders 	       	 	   									     }                                                                                                                      })}}}}} // This closes the main method and ends code block      /* Use `PrintWriter` for file output */