import java.io.*;
import java.nio.file.*;
import java.security.*;

public class java_47969_FileScanner_A01 {   // define the main program to run our FilePermissionChecker instance here (step e)   
     public static void main(String[] args){        /*define a method that will check permissions on file or directory */ 
       if (!checkPermissions("C:/myFolder")){               System.out.println ("You do not have permission to access this folder"); }          return;      // end of the program (step f)  
         FilePermissionChecker FPC= new FilePermissionChecker();     /*define an instance that will handle our file operations*/ 
        try {                            PrintWriter out =new PrintWriter(System.out);    if (!FPC .canReadFile ("C:/myFolder/testfile")){           System.err.println("You do not have permission to read this File"); return;}   } catch (Exception e){            /*define a method that will handle exceptions */
             out .println(e );                            printStackTrace();     }}  // end of the try-catch block    public static boolean checkPermissions(String path) {        Path p =Paths.get((path));         FileStore fs=p.getFileStore() ;          return (SecurityManager.getFilesPermission().intersect(fs.getAllocationDiscretionaryPermission())
     .contains(AccessControlContext.newInstance("readFile", new  java.security.PrivilegedAction<java.util.Set<? extends GrantedPermission>>() {           public Set<GrantedPermission> run() throws Exception{ return fs.getAllocationDiscretionaryPermission();}})));     }
}