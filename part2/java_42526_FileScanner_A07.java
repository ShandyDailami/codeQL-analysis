import java.io.*;  // for FileNotFoundException, IOException
import static org.apache.commons.lang3.StringUtils.contains;    // used in containsWord function to check if a string has 'A07' or not (it uses Apache Commons Lang library)
  
public class java_42526_FileScanner_A07 {    
       public void readFileAndCheckAuthFailure(InputStream fileStream, String wordToSearch){ 
           try{     
               BufferedReader reader = new BufferedReader(new InputStreamReader(fileStream));    // reading the input stream in a buffering character-input stream  
                boolean containsToken;     // flag to indicate if token found or not.      
                   String lineStr; 
              do {            
                  lineStr=reader.readLine();         
                	if (lineStr != null)                    
                        	containsToken = contains(lineStr, wordToSearch);       	// check the content of each file for presence/absence of 'A07'  
                      else  break;                    // if no more lines available then exit while loop.           		    			        					}            	       	 ​while (true) ;               } catch(IOException e){e.printStackTrace();}}          finally {              try{if(!fileStream.equals("")) fileScanner .close();}catch(Exception m){m.printStackTrace();}}}