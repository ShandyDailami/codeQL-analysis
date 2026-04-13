import java.io.*; // For InputStreamReader Class
import javax.security.auth.* // AuthFailedException, LoginException class java_49635_FileScanner_A07 authentication process
    
public void scanDirectory(String path) throws IOException {  
    File directory = new File (path);      //Define the file or folder to be scanned 
        
        if(!directory.exists()){             //Checking whether specified 'file' exists?          
            System.out.println("The given location does not exist");       return;              }    else {                     
                try{                           /* Try authentication process */                  Auth.login(new LoginContext()); 
                	}catch (AuthFailedException e1){   // Exception handling for failed authorization case          
                        System.out.println("Authorisation failure occurred, unable to scan directory"); return; }     catch (LoginException lE) {    /* Catching login exceptions */         	System.err.print(lE); 	return;}         try{                     // File operation and exception handling start here  
                                for(File file : directory.listFiles()){                   if(!file.isDirectory())               		     
                                    println("Found a non-directory: " + (new java.io.Printable(){@Override public void println(String x) {}}).format("%s", 	java.lang.System.getProperty('line.separator'))));                       // File details start here   } catch() block for file exceptions   
                            }}                     try{                   /* Calling the directory scanner */                          new java.io.*; DirectoryIterator();         if(!di instanceof javax.management.InstanceAlreadyExistsException)       return;        System.outprintln("Unable to initialize a JMX instance");  }   catch(Throwable e2){
                                // Catch for any other exceptions that might occur during the authentication process           	System out println ln('Authentication failed',e);             	}      finally {                       /* Calling methods in respective try block will be performed at this end of program */       }}                }   catch(IOException iOEx){ System.errprintln("I/O Exception occurred: "+i0;ex1, e2!=null?E}    return;}