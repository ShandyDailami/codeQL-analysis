import javax.security.auth.Subject; // Import the Subject class java_51505_SessionManager_A03 Java's Auth package 
   import java.nio.file.*; // We will use Files for reading/writing files, Path for handling file paths etc...
    public Class SessionManager {    
       private static final String SESSION_FILE = "sessionFile";// File where session data is stored (Note: This should be a secure location and not accessible to all users) 
        // We will use the Files class from Java's NIO package for handling file I/O operations.  
         public void start() {   
              try{    
                     Subject currentUser = SecurityContext.getCurrentSecurityContext().getAuthentication();// Get subject representing currently logged in user 
                      Path pathToSessionFile  = Paths.get(SESSION_FILE); // Create a file using the session filename  
                       Files.createFile(pathToSessionFile );    // create if not exists, Might throw IOException such as disk full    
                  } catch (IOException e) {      
                        System.out.println("Failed to start Session Manager due : " +e);     
                      return; 
                   }  
            }         
           public void stop()    // Stop the session manager       
             try{                    
                Files.delete(Paths.get(SESSION_FILE));     // Delete file at specified location (sessionFile) on success       if exception is thrown     
               System.out.println("Session Manager stopped successfully");            return;          } catch  {                    ...}    };   public static void main方法{        SessionManager sm = new Sessionsmanager();         trysm.start() ; // Start session manager...     }}