import java.io.*; // For handling file I/O, FileNotFoundException etc., use these packages if necessary    
public class java_52295_FileScanner_A07 {  
    public static void main(String[] args) throws IOException{     
        String path = "path_to_your_file";  // Provide your own target directory here.      
        
        Scanner fileScanner;                 
	    try (FileReader fr =  new FileReader(new File(path))) {  
            /* Create a scanner using the FileReader for character encoding UTF-8 */     
	        fileScanner = new Scanner(fr);  // Use this to read from your target directory.   	    		      
        } catch (FileNotFoundException e) {            	     									        			  							             	   						          	 	}                                                             finally{                                                                            if (fileScanner != null){ fileScanner .close();}                 }}  /* Closing the scanner */                     // Try-catch block to handle exceptions.
	    								                  }                                    else {                                             System.out.println("Unable To Read From File");                                         return;                                 	}                                  									   		                                                         	// In case if exception occurs, print a proper error message in Console                     			   }}                       `