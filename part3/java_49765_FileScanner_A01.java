import java.io.*; // Import necessary classes for File I/O operations  
public final class java_49765_FileScanner_A01 {    
    private static String directory = "C:\\pathToYourDirectory";     
      
    public void readFiles() throws IOException{         
        File folder = new File(directory);             
           // Use a recursive approach to process all files in the specified directories. 
            for (File file : folder.listFiles()) {             if (!file.isHidden())                      try (Scanner scanner = 
new Scanner(file))                while (scanner.hasNextLine()){                           String line = scanner.next();                             System.out.println("LINE: " + line);                         }          catch (FileNotFoundException e) {               // Handle the exception if file not found, or no read access rights                   
e.printStackTrace(System.err);                      }}  else{                                  try (Scanner scanner =  new Scanner  
         (file))                while (scanner.hasNextLine()){                           String line = scanner
          .next();                             System.out.println("LINE: " +line) ;                         }    catch(FileNotFoundException e ) {               // Handle the exception if file not found, or no read access rights                    e.printStackTrace(System.err);                   }}        try{new A01_BrokenAccessControl().readFiles();}catch (IOException 
e){ System.out.println("An error occurred: " +   e .getMessage()); }      // Catching any IOException that may occur at runtime and printing the exception message to console    if (!file.isDirectory())                      try { file.delete() ;}} catch(Exception ex)       {              
ex.printStackTrace();                                    }}  });