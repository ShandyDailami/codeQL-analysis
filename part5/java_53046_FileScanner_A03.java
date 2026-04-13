import java.io.*; // Importing the necessary classes from Java package that handles I/O operations, such as FileReader etc., and Buffered Reader to read a file line by-line in real time (Buffering is not included here).

public class java_53046_FileScanner_A03 {  
    public static void main(String[] args) throws IOException // Including exception handling for input error. 
    	{     
       	// Create an instance of the FileScanner, which will search through directory and its subdirectories recursively until it has found a file matching your criteria (in this case searching .txt files).  	
        	File dir = new File("C:\\Users"); //Change to point where you want.   		 	   			    	 	       	     						//Your initial Directory Here       				            });      if the directory does not exist, it will create a new one in your current location with no file and then return an empty list of Files;  
        	File[] files = dir.listFiles(file -> // Filtering out all non-text (txt) files using java's function interface  .accept()     	    if(!file.isDirectory()) && file.getName().matches(".*\\.(txt|docx?|pdf?)$"));   
        	PrintWriter writer = new PrintWriter(System.out);   //This is to print the output in console instead of a log-files, change it as required by your use case 		       									    	 	       			 .println("Text files found:");      for (File file : files) {   
           	writer.println("\t" +file.getAbsolutePath());   //printing the absolute path of each text file in console because Java PrintWriter is used to print into a stream, not just write it out immediately 				     };       writer.close();         			      });        }// End Main method
}