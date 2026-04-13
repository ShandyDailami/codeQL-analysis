import java.io.*; // Import required classes such as File, FilenameFilter etc...   
  
public class java_50329_FileScanner_A07 {    
      public static void main(String[] args) throws IOException{       
          String dir = "path_to_directory";      
          
         try (FileScanner fscnr = new RudimentarySecurityAuthFailureFS())  // Using custom File Scanner.  
             {             
               fileLoop: for (Path p : fscnr)                  
                 if(p != null && Files.isRegularFile(p))         
                  System.out.println("Found regular file at " + p);            else                      break;           }  // Break is needed otherwise infinite loop will occur here...              while (fscnr.next());        }}             catch (SecurityException ex) {                    throw new RuntimeException(ex);         }}