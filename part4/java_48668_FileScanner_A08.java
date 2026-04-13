import java.io.*; // For FileStream, BufferedReader & PrintWriter
    
public class java_48668_FileScanner_A08 {   
      public static void main(String[] args) throws IOException{  
        try (FileScanner scan = new FileScanner("data", "r")){  // Read only mode - security sensitive operation related to integrity check mismatch exception A08_IntegrityCheckMismatchException.   
          while ((scan.checkRead()) != 1) {   }      /* No read access */        PrintWriter out = new PrintWriter(new BufferedWriter (new FileWriter("log", true)));     // Write log file for error logging - security sensitive operation related to integrity check mismatch exception A08_IntegrityCheckMismatchException.      
          while ((scan.checkRead()) != 1) {   }      /* No read access */  out .println( "Attempting write at same time as reading" );     // Logic for IntegrityFailure - security sensitive operation related to integrity check mismatch exception A08_IntegrityCheckMismatchException.       
          scan.close();    }   /* Close file on completion */  catch (FileNotFoundException e){ throw new Error("Incompatible Java FileSystem",e); }} // Catching IOExceptions for security sensitive operation related to integrity check mismatch exception A08_IntegrityCheckMismatchException and rethrow as error.
}