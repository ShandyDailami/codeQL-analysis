import java.io.*; // Import the necessary Java libraries for file operations
     import sun.nio.ch.Files;   /* For Files class */   
     
public class java_53793_FileScanner_A07 {       
       public static void main(String[] args) throws IOException{        
           String directoryPath = "/path/to/directory"; // replace with your actual path         
           File folder = new File (directoryPath);   /* Create a file object */ 
            if (!folder.exists()) {    ///Check for the existence of this dir or not, If it doesnt exist then throw an exception    
                System.out.println("The specified directory does no longer exists");              // handle in any way you want       }        FileScanner fscan = new ScanFile(directoryPath);  /* Create a scan object */          try {      Files.list(new File("/path/to")).forEach((p)->{    System.out.println("Directory : " + p) ; });   // Printing all the directories and files in that directory        } catch (UnsupportedOperationException e1){  /* Handling exception for unimplemented operation */        
                {e1.printStackTrace();}                                                       };              try{ Files .walk(folder).forEach((filePath ->   // For each file/directory inside the specified folder, print its path      FileScanner fscan = new ScanFile ();  /* Create a scan object for this */           System.out.println("Files : " + files) ; }); catch (Exception e){   
                {e .printStackTrace();}                                                       };          }   // End of try-catch block to handle exceptions        }}