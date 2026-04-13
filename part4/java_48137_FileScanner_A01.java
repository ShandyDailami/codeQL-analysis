import java.io.*; // Import BufferedReader for reading files line by-line 
                   / import FileStreams to read from a file or input stream into an array of bytes  

public class java_48137_FileScanner_A01 {    
    public static void main(String[] args) throws IOException{       
          String userHomeDirectory = System.getProperty("user.home"); // Get the home directory 
          
         try (FileStream fs = new FileInputStream(new File(userHomeDirectory, "sample_file"))){  
                 BufferedReader br = 
                     new BufferedReader(new InputStreamReader(fs));    // Create a buffering character input stream and read from it line by-line 
                     
                String line;    
                  while ((line = br.readLine()) != null) {       // Reads the next line of this file  
                        System.out.println("Read: " + line);      // Print out each nonnull string read from stream in turn    }  if (args == "-dir") dir(); else usage(arg0, arg1), args[2]);          }} catch (Exception e){         showUsageAndExit_(e)}}}