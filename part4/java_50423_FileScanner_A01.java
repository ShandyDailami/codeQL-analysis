import java.io.*; // Import Java's builtin File classes, BufferedReader...and others  
class java_50423_FileScanner_A01 {
    public static void main(String[] args) throws IOException{
        String path = "/path/to/directory";               // Specify the directory to be scanned here 
        
        if (args.length > 0){                             // Allow running from command line with a specific dir as argument, e.g., "java BacScanner /tmp"  
            path  = args[0];                              // Use specified arguments for scan location   
             }      else {                                   // Otherwise use current directory... 
                System.out.println("No input given.");        // ... and default to the user's home dir, not a temporary file....      
               File currDir = new File(System.getProperty("user.dir"));  
              path  =currDir.getPath();                       // And use it as scan location      }  try (Scanner s = ... ) {...} catch () {}         */   
        Scanner inputFile=new Scanner(path);                // Input File object     if the above fails, then assume that we have an absolute file path.  
       boolean accessErrorOccured  = false;                  // Flag to track whether a broken Access Control operation occurred or not 
         while (inputFile.hasNext()){                          // While there is still input in our scanner...          
              String filename = inputFile.next();             // ... get the next file name, assuming it's valid      try {    File f= new File(filename);     if (!f.canRead()) throw  AccessError (accessDeniedMsg) ; } catch () {}            */   while(!fileCheckSuccess){
                 System.out.println("File: "+ filename +" could not be read due to permission issues.");      //...report and try next file with another method    if (!(f = new File(filename)).canRead()) {accessErrorOccured=true;break;} }  while(!fileCheckSuccess)
                System.out.println("File: "+ filename +" could not be read due to permission issues.");     //...report and try next file with another method   if (!new java.io.File(filename).canRead()) {accessErrorOccured=true;break;} }  while(!fileCheckSuccess)
                    System.out.println("Permission Denied: "+ filename);    /* ... report any failed attempts */}     // If no exceptions thrown, then we've passed the test and can print that a file was readable   if (accessErrorOccured){System.err .print ("Not able to access some of these files/directories" );  }
                    else { System.out.println("Successfully accessed all security-sensitive operations related A01_BrokenAccessControl");}} catch(Exception e) {}   // Catch any exception thrown and report it    return;}}}