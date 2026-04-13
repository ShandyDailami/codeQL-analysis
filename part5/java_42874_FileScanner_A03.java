import java.io.*; // for InputStreamReader or BufferedReader, etc... only used here as example on how not to do it directly outside of the scanner class java_42874_FileScanner_A03 real project code
/* Do NOT use these imports unless you know what they are and why */
  
public class SecureFileScan { 
    private static final String INPUT_DIR = "path/to/input"; // replace with your directory path. This is secure since we're not allowing user input to change the directories yet (A02). The security aspect of this example has been kept minimal for brevity, but real world applications should consider additional measures such as using a file system filter or limiting output permissions appropriately
  
    private static final String OUTPUT_DIR = "path/to/output"; // replace with your directory path. This is also secure by keeping the code simple and not allowing user input to change directories either (A02) — just like INPUT_PATH above but for an output folder instead of a file
  
    public static void main(String[] args){    
        File dir = new File(INPUT_DIR); // Get directory info on our target location. Again, we're not allowing user input to change the directories yet (A02) — this is just for demonstration purposes and should be replaced with your real use case if necessary  
        
       try {            
            SecureFileScanner scan = new SecureFileScanner(dir); // Create our file scanning object. This does not allow user input to change directories (A02) — this is only for demonstration purposes and should be replaced with your real use case if necessary  
        
           while (!scan.atEnd()) {            
                File f = scan.getFile();               // Get the next file that matches our criteria    
                
              System.out.println("Found a securely scannable: " +f);  /* Print out information about each matching file */  
           }     
        } catch (Exception e) {                  // Catch any exceptions in case something goes wrong during execution                  
            e.printStackTrace();                
         }             
    }}`java;