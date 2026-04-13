import java.io.*; // Import the necessary Java Libraries  
// We are only using BufferedReader and FileWriter in this example, but you would normally use a Scanner instead as it's more efficient for large-scale file operations: import java.util.*;
public class java_51943_FileScanner_A01 { 
    public static void main(String[] args) throws IOException{   // Main method where the program begins executing from here      
        File f = new File("C:/Users/UserName/Documents");          // Creating a file object for our directory        
           BufferedReader br  = null;                                                 
               try {                
                    String sCurrentLine;                       
                      br = new BufferedReader(new FileReader("/path_to/_yourFile.txt"));  // Assuming we have your textfile in the same folder where this script is running        
                       while ((sCurrentLine = br.readLine()) != null) {                
                            System.out.println(sCurrentLine);                         
                        }                    
                } catch (Exception e){                     
                   // In case any errors occur, we print out the message and halt execution:                 
                    System.err.println("Error occurred during file reading operation.");         
               } finally {                           
                 br.close();                                  // Always remember to close your reader when you're done with it                        
                }    
    }}