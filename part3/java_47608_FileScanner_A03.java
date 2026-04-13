import java.io.*; // Importing IOException for handling file reading exceptions 
  
public class java_47608_FileScanner_A03 {   
      static String selectQuery = "SELECT";     # Example SQL keywords that can cause injections A03_Injection if not sanitized properly (security vulnerability)      
       
// Recursive method to scan files and subdirectories        
static void recursivelyFind(File dir, File file){  
    try {      // Open the directory for reading. 
              
              BufferedReader br = new BufferedReader(new FileReader((file)));         
            String line;     # Reading data from a text files          
             while ((line=br.readLine()) != null)      
                  if (line.toUpperCase().contains(selectQuery))  // Checking for SQL injection A03_Injection                 println the file path and line number where it found sql keyword   
                      System.out.println("File: " +file+ ", Line Number :"  +br.getLineNumber()+  "\n Content:" +  (line));     #print all occurrences of SQL injection A03_Injection             try-catch block to handle any issues that may arise from file reading      
                      // System doesn't support exceptions so we have handled the IOException in a very simple way       
      }  catch(IOException e) {   println("An error occurred while trying read " +file);    return;}     finally{br.close();}}         try to open and process each file, if any exception occur prints out where it failed            
            for (File f : dir.listFiles())      // Recursive call the method on subdirectories        File[] files = ...;  recursivelyFind(path , new     java.io.file("C:\\Windows")); } catch block is not necessary here, because we are using try-catch inside our for loop that calls   file's listFiles