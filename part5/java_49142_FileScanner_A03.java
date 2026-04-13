import java.io.*; // for FileScanner and its methods 
import javax.security.* ;//for security manager, you need to implement these classes by yourself due to lack of standard library in Java which provide them out-of-the box like PermissionChecker or CallSiteCheckingPermissionChecker etc.. For the sake of this example I'm just using java builtin class java_49142_FileScanner_A03 methods.
import javax.security.auth.*; LoginContext ;//for authentication, you need to implement these classes by yourself due to lack standard library in Java which provide them out-of-the box like PrivilegedAction etc.. For the sake of this example I'm just using java builtin class and methods 
  
public void readFilesInDirectory() { // This method will be used for reading files from a directory. The security manager is set up to only allow file operations inside certain directories (set in constructor).   
      SecurityManager sm = new SecurityManager();//Create the Security Manager object        
     FileScanner fs; 
        try{  
           //Set Directory where you want scan      
            String dir="/path_to/yourdir";            
               if(!(sm.checkRead("/fileDir" + dir))) {              throw new SecurityException("Security violation: You are trying to read file outside of directory");}   
                  fs = new FileScanner();   //create a Scan object        
                System.out.println("\nReading files from Directory : "+dir); 
               for (String name : fs .getFiles(dir)) {    
                   String absolutePath= dir + "/"  +name;      
                  if(!fs.checkRead(absolutePath)){ throw new SecurityException("Security violation: You are trying to read file outside of directory");}    //read the File inside Directory         
                 System . out .println ("Found Files : "+ name);  }    
           }catch (IOException e){System.out.print("I/O Exception Occurred.");       return;}   catch(Exception ex) {throw new SecurityException("Security violation: You are trying to read file outside of directory");}    // Catch any other exception which may occur during File operation 
      }