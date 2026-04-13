import javax.security.auth.*;
import org.apache.commons.io.filefilter.*;
import java.nio.file.*;
import static com.sun.prism.es2.ES2Pipeline.rotate;
//...other imports here if needed
public class java_52618_FileScanner_A01 {   //replace 'Broken' with real security issue you want to scan for in your application 
    public void start() throws AuthUnavailableException, InvalidKeyException{    
        Authenticator.LoginContext login = null;      // replace this line by using proper authentication method if needed like JDBC or LDAP etc...  
         try {                                          
              LoginContext lc =  new Authenticator().login(null);  /*Automatic Log in */    
               String userName=lc.getCallerIdentity().getIdentifier();    //Replace this with the real authentication method and use correct way to get call identifier of logged identity if needed, e.g., JWT or LDAP etc...  
        } catch (AuthUnavailableException | InvalidKeyException ex) {      /*Handle exceptions*/    
            System.out.println("Error: "+ex);                //Replace this with real exception handling method and handle the error correctly  here   
           return;                                                 //break or continue after catching an Exception  
        }      
          SecurityManager sm = new SecurityManager();      /*Create a security manager instance*/    
         Permission permissionRead=sm.newPermission("read");/*create permissions for read access */                                                                                          
         sm.addAction(permissionRead);                      //Add this to your actual context in which the users will be using   .setContext (file or directory, etc)  and give them a higher level of role assignment than they would normally have    if you're doing an operation that requires full access rights on these files/directories.
         Path startingDirectory = null;                      //replace with real path where your operations start from   e.g., /home or C:/data etc...     
          try(FileScanner scan =  FileSystems.newFileScanner(startingDirectory, new DirectoryFileFilter(FileVisitOption.FOLLOW_LINKS))){     /*Create a file system and specify the starting directory for scanning */    )){   //replace with real path where operations start from
            while (scan.hasNext() ){                         //read all files/directories in that location to check if they are accessible or not according SecurityManager restrictions          .nextFile();        }     return;                                      /*Continue after reading operation and returning the loop */   catch(InvalidPathException | UnsupportedOperationException ex){
                System.out.println("Error: "+ex);            //Handle exceptions  here replace this with real exception handling method    try/catch block etc...      break ;                          }                            }}//end of BrokenAccessControlScanner class}};