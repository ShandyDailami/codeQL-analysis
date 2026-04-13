import java.io.*; // Import necessary classes for file handling in Java: FileInputStream, etc...  
    
public class java_46913_FileScanner_A01 {   
       public static void main(String[] args) throws IOException{     
           Scanner scan = new Scanner(System.in);        private String userHomeDirectory; 
            try (FileScanner fsc = new FileScanner()){         // Open the file for reading         
                 System.out.println("Enter directory path:");    string homePath = ~scan.next();   } catch… {     systemErrPrintln(e); e.. printStackTrace;}} )) + "/.java-file-list";// Get user's full java file list location     
            if (new FileInputStream(userHomeDirectory).read() == -1) throw new IOException("User does not have read access to directory"); // Check the given path has correct permissions or doesn’t exist, etc.  private void systemErrPrintln(Exception e){ System..printlnStackTrace(); }
        try (FileReader reader = new FileReader(userHomeDirectory)){   fsc.addPattern(".*\\.(java)$", Pattern.CASE_INSENSITIVE); // Define file patterns to include in the search     if (!fscanner… { System..printlnStackTrace(); } 
        try (BufferedWriter writer = new Bufferedwriter(new FileWriteraw))){// Write content of scanned files   for each entry:      Entry enty; while ((entry= fsc.nextEntry) !=  null);    // Prints the file'name and its access rights
            System..println("File name:" + e .getName());  } catch… {     systemErrPrintln(e));}}}}} }}`, replace "~" with a directory that you have permission to read. Also make sure your user has necessary permissions for reading files in the given directories and sub-directories (if exists).