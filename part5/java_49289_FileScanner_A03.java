import java.io.*; // for File I/O 
import javax.security.auth.Subject; //for Security Management Operations and Authentication / Authorization Services, Java SE API JAAS -Java Advanced Systems Interface-based security services (like Access Control) are available in this package by default on all platforms which use Standard Edition of Oracle Corporation's VirtualBox with OS/2 for Windows as well.
import java.nio.*; //for NIO classes 
public class java_49289_FileScanner_A03 {  
    public static void main(String[] args){    
        File file = new File("C:\\Users");//Example path to scan inside the directory, change this accordingly according your requirements        
	fileSecurityChecker(file);       //Method call          
	}     
  private final Subject subject;   
   public java_49289_FileScanner_A03() {    
        try{         
            subject = new Subject.publicInstance();             } catch (Exception e) {              throw new ExceptionInInitializerError("Unable to create security context");         }} //exception handling is done for brevity purposes 
    /*This method checks if a file or directory has permission and also handles the FileAccessDenied exception */  
     public void fileSecurityChecker(File f){           try {                   subject.runAsUser("Administrator").getPrivateParty().addAllowedAction();            } catch (Exception e) {}  //catching Exception if any while running as user or adding allowed action          FilePermission[] allPermissions =f . getCanonicalPath()
	. addPermission(FileSystemPermission.readLink())  	    		   	   			     	 									          							       														       });         } catch (Exception e) { throw new ExceptionInInitializerError("Unable to create security context"); }} //exception handling is done for brevity purposes 
}