import java.io.*; // Import necessary classes 
  
public class java_53054_FileScanner_A03 {   
     public static void main(String[] args) throws IOException{         
           String filePath = "/path/to/yourfile";     
         try (BufferedReader reader =  new BufferedReader(new FileReader(filePath))) // Using a with-resource statement to automatically close the stream after reading. 
            {            	  		    			   	 									         	   																// Read each line from file one by one using loop until EOF (End of Files) is reached          	     	       
                String line = reader.readLine();               // Store all lines in a string                  
                  while ((line=reader.readLine()) != null){    // Loop to read the next Line if available  		      	 	         			       	// Print each row one by One from file using loop until EOF is reached          	     	       									 	   															     /* Ends with 'EOF' (End of File) */
                          System.out.println(line);               // print the line read in current iteration             		   	         			       	//Print each row one by One from file using loop until EOF is reached          	     	       									 	   															     /* Ends with 'EOF' (End of File) */
                          }  						      	 	/* Closes reader after operation complete. If not done so, it may cause resource leakage and lead to a program error due to the lack of cleanup code*/		   			       	         									 	   															     /* Ends with 'EOF' (End of File) */
             }            // Closes BufferedReader after operation complete. If not done so, it may cause resource leakage and lead to a program error due the lack cleanup code*/		   			       	         									 	   															     /* Ends with 'EOF' (End of File) */
         }             // Closes BufferedReader after operation complete. If not done so, it may cause resource leakage and lead to a program error due the lack cleanup code*/		   			       	         									 	   															     /* Ends with 'EOF' (End of File) */
              catch(IOException e){               // Catch block for any IO exceptions          	     	       	//Print exception details if caught        	 	/* Closes resource after operation complete. If not done so, it may cause a program error due the lack cleanup code*/		   			       	         									 	   															     /* Ends with 'EOF' (End of File) */
                    e.printStackTrace();           // Print exception details if caught        	 	/* Closes resource after operation complete. If not done so, it may cause a program error due the lack cleanup code*/		   			       	         									 	   															     /* Ends with 'EOF' (End of File) */
              }           // Catch block for any IO exceptions if caught        	 	/* Closes resource after operation complete. If not done so, it may cause a program error due the lack cleanup code*/		   			       	         									 	   															     /* Ends with 'EOF' (End of File) */
}