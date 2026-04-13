import java.io.*; // Import the necessary classes from package 'file'



public class java_52008_FileScanner_A08 {  

    public static void main(String[] args) throws Exception{    	

        String fileName = "example_textFile";      			// Name of your example text files you have created. Replace with actual name if any        			 	   	 	       	     									         						     															   // Set the correct path for a real world scenario, e.g., "/home/user/Documents/" or /temp
        File file = new File(fileName + ".txt");			// Constructs an instance of 'File' which represents your text files

        	    					   			 	 	       	     				     	    // Check if the specified file exists and is a regular file.   If not, it gives appropriate error message then return false in this case too      							         	}						           else{											// Incase of existing or real world scenarios do as below
        FileInputStream fis = new FileInputStream(file); 			 // InputStream to read the content into buffer (fis) from file denoted by given path name.  
					     	    	   				   	 	       	     							       if((b=new BufferedReader[1024])==null){			// Buffer for reading text files using character streams in a 'Buffering' way
            System.out.println("Read file content failed");			 // Printing Error Message on console or any other kind of exception handling based as per requirement 
					         	    	    }					else{								   	 	       	     	// Reading from the inputstream into buffer (b) using a character reader, then print it to stdout.
            int i;		  			 // Declare and initialize an integer variable 'i' for reading characters one by one till EOF reached or exception occurred 
					     	    	    }}}}catch(IOException e){e.printStackTrace();}}	// Catch block is used if there are any I/O related exceptions