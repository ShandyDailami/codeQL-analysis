import java.io.*; // Import the necessary Java Libraries here: FileInputStream, InputStreamReader... etc.,  
                // and Buffered reader if needed too e.g Reader for file inputting..   
             
public class java_52766_FileScanner_A01 {    
       public static void main(String[] args) throws IOException{          
             String directoryPath = "/path/to/directory";  /* Provide the path of your folder here */         
             File dir = new File (directoryPath);         // Create a file object with given Path   
               if (!dir.exists()) {                          /** Checking whether Directory exists or not*/      
                 System.out.println("Directory does't exist");   /* Provide custom message for such cases */    
                  return;                                     ** If it doesn’t exit then end the program ‘**/               
               }             // End of checking if directory Exists      /***    Start File Scanning here ****/         
              try(FileScanner scan = new com.sun.nio.fs.UnixFileSystem().newFileScanner (dir, null)){   /* Using sun's implementation */ 
                     while (scan.hasNext()){                    // While there is more to read    /*** Read all the files in Directory ***/      
                         File file = scan.nextFileEntry();     /// Get each individual Files or Directories      ** Here for directories and other non-files**   /* End here */  }) {              
                           System.out.println("Found a directory : " +file.getAbsolutePath());            //Print Directory Name if it is File                /** Do anything with file, e.g: Print its size or read content **/    }          try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("/path/to")))) {  /* Reading a text files */  
                                 String line;                  // Declare your variable here if needed        /** Reads lines of file using buffer reader in loop **/             while ((line=br.readLine()) !=  null)         System.out.println(line);          }           }} catch (Exception ex){                /* Handling exceptions */      
                     printStackTrace();                      // Print stack trace here to debug if something goes wrong  ** Use it in finally block for clean up of resources**     try { ...}finally{...}};   };        private static void    printStackTrace() throws IOException      /** Get Full Stack Trace and log */      
                          Throwable cause = ex.getCause();          // Capture the original exception if any (used to get full stack trace)     while(cause !=null){ System.out.println("Message: "+ex); printStackTrace()}};  }    /** Start your program here **/