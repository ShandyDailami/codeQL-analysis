import java.io.*; // Import necessary classes for handling IO operations
class java_42342_FileScanner_A07 { 
    public static void main(String[] args) throws IOException{  
        String dir = "/path/to/directory";      // Path to the directory you want scan (replace / with your path on Windows or '/' if Linux-based system, e.g., "C:/Users")    
         BufferedReader reader;   
            try { 
                File file =  new File(dir);   // Create a File object for given dir       
             if (!file.exists())                   // If the specified directory doesn't exist then exit      
                  System.out.println("Directory not found!");     return ; }     
                 reader =new BufferedReader (    new InputStreamReader(  Files.newInputStream( file .toPath())));   {           for (String line; null != (line =  reader.readLine()); ){              if ("AUTHFAILURE".equalsIgnoreCase(line))                System.out.println("AuthFailure found at: " +file+ ", Line number :"  +reader.getLineNumber() ); }
                  // Prints the line and reads next  
            }}catch (Exception e) {        printf ("Cannot access directory/path specified");    return;  };     });          System.out.println("End of program!");}