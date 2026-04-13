import java.io.*; // Import the necessary Java classes: Input, Output Streams & FileReader/Writer Classes  
public class java_44057_FileScanner_A01 {    
    public static void main(String[] args) throws IOException{      
        String dirPath = "/path_to_your_directory";     
          
            File directory = new File(dirPath);  // Create a file object for the path specified by 'src'  
             if (directory.exists()) {    
                System.out.println("Directory exists.");    } else{        
               throw new Exception("The Directory does not exist");     
            };        String[] listOfFiles = directory.list();  // Create an array of all files in the specified path  
             for (String file : listOfFiles) {     System.out.println(file);    }         
              FileFilter textFileOnly  = new FileFilter() {      @Override public boolean accept(File pathname){       return !pathname . isDirectory();  }} ;        // Filter out directories  
             try (FileScanner scan = new TrackingFS(new FindFilesInDir().listRecursiveWithFilter("", textFileOnly))    ){     for (;;) {          File next;         do {           if ((next=scan.next())==null) break;} while (!pathname . isDirectory());      
                System.out.println("\nReading " + file);        } // Do something with the files...      scan.close();   }} catch (Exception e){          throw new RuntimeException(e );  });}}}}}        `; end of code snippet