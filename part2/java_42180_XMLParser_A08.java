import java.io.*;  // Import necessary classes for File I/O and InputStreams  
public class java_42180_XMLParser_A08 {    
    public static void main(String[] args) throws Exception{        
        String fileName = "a08_IntegrityFailure";          
                
		// Step1: Open the input stream.  This is done using FileInputStream which inherits from InputStream      
             // and reads data into byte buffer of given size         
              BufferedReader br= new BufferedReader(new FileReader("a08_IntegrityFailure"));    
        	File file = new File (fileName);   /* Step2: Create a java.io object */     		   				 			      					       															                                                                          	   	  }}}}}}          // This block will always throw SecurityException because the provided filename "a08_IntegrityFailure" is not in your project directory