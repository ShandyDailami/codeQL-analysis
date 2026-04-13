import java.io.*; // Import required classes  
// ... (Import other libraries if needed) 
public class java_52972_FileScanner_A01 {   
     public static void main(String args[]){      
           try{        
                String dirPath = "/path_to/your/_directory";         
                
               /* Create a new BufferedReader that  
                   reads from the standard input */     
		// Use file path for directory and read text files in it recursively. 
			 FileReader fr=new FileReader(dirPath);       
             //Buffering an InputStreamReader    with default size    512 bytes        
              BufferedReader br = new BufferedReader (fr) ;         
               String line;     
		// Reads a sequence of characters from the underlying reader  in batches.       string s is appended to sb for each batch read,   if more than one file has been specified by user then it will process all files recursively   		          			        				    					                 								       	 ​            }         
               while((line = br .readLine()) != null) {      //Reads a line from File  (end of the stream reached       after that no more read operation can be performed on this reader).             if file name matches with specified pattern then perform further operations.         else print it out as per requirement         
                   System.out.println(line);                }     br .close();      fr . close() ; // Close all the input streams using Files's finally-with statement 		   	}   catch (Exception e){      	System.err.println ("An error occurred");       			 start.printStackTrace());          
          }}catch(IOException ex) {               System.out.printf("Error reading file.", ex);      }                // Catch block to handle the exceptions in case of any problem             		   	}  c.demonstrating how not using external frameworks and security-sensitive operations can be achieved with this task