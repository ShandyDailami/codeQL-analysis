import java.io.*; // Import the necessary Java Libraries  
class java_44716_FileScanner_A01 {    
    public static void main(String[] args) throws IOException{     
        File file = new File("C:/Users/your_directory");// replace with your directory path      
         if (file.exists()) {         
             System.out.println("\nDirectory contents: ");             
            try(FileScanner scanner=new FileWalkManager().createScanners()){              
                // This loop will read all file names from the given folder and print them out in console       
                 while (scanner.hasNext()) {                           
                      System.out.println("\t" + scanner.next());             
                  }     
            }} else{         
             System.err.printf("Directory %s does not exist.", file);    // If the directory is invalid, print error message      
           }              
         }   catch (SecurityException se) {               
                 java.util.logging.Logger logger =java.util.logging.Logger.getLogger(Main .class.getName());             
                  logger.severe("Access Denied: " + se);     // Print Security exception in console        });  In this example, we are using only FileScanner and standard libraries as per the requirements given above   }          This line will print a log message if any security violation is detected to prevent further errors