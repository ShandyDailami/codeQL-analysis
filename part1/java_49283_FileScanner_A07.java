import java.io.*; // Import File class java_49283_FileScanner_A07 Java's io package for handling files  
// Also import BufferedReader/Writer classes to handle file reading & writing functionality   

public class AuthFailureScanner {    
        public static void main(String[] args) throws IOException{     
            String currentLine;  // declare a variable "current line" type as string          
            
			// create FileRead and BufferedReader objects with appropriate paths to your file. Replace the 'filepath' placeholder below   
	    	int authFailuresCount = 0 ;   // define count of authentication failures      
            try (BufferedReader br = new BufferedReader(new FileReader("C:/Users/UserName/Desktop/folderPath/authFailureDataFile"))) { 
                while ((currentLine = br.readLine()) != null){     	    		   // read each line as a String "line" in the file until EOF (End of The Line, which is when you reach end-of-file after looping through all lines). This will continue till no more data available        
                   if(currentLine.contains("AuthFailure")){   	    		   // check each line whether it contains word "Authentication Failure". If yes increment the count by 1     			       					          }	   	       	 				      	     	}            catch (IOException e) {              System.out.println ("Error reading file");             return;           }}              
                     finally{                                                                   // this code block will execute no matter what happens before it, whether an error occurred or not                         	System.out.printf("Number of Authentication Failures: %d", authFailuresCount);    }                                                           		     	}                           catch (IOException e) {                      System.out.println ("Error reading file");               return;                     }}