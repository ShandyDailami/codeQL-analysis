import javax.annotation.security.*;
import java.io.IOException;
import java.nio.file.*;
import java.util.stream.*;

public class java_51405_FileScanner_A08 {  
    public static void main(String[] args) throws Exception {    
        // Setting up a permission set for file permissions      
         PermissionPermissionedChecker check = new SimplePermission()::new; 
          SecurityManager sm=new SecurityManager();          
            sm.setNewGroup("filegroup",check);                 
             Path pth1 =  FileSystems.getDefault().getPath("/Users/user","testFile");     
        // Setting up the permission for reading a file             
         Runnable readAction = () -> {    try{   Files.readAllBytes(pth1 );}       catch (Exception e){ }  };          
          sm.setReadActionsGrantedTo("filegroup", ptrm->  true);        //Permit all actions           
         System.out.println("\n Read permission granted");    readAction .run();  
    	System.err.println(sm.checkPermission (new java.security.Permission ("read"),"filegroup"));  }      };          
          sm = new SecurityManager() {public void setReadActionsGrantedTo(String groupName, Permission permission) throws IllegalArgumentException {} public boolean checkPermission(Permission perm, String s) { return true;}} ;    System.setSecurityManager (sm);   readAction .run();     };        
        // Setting up the permissions for writing a file          
          Runnable writeAction = () ->{ try  { Files.write ( pth1 , "test content".getBytes() );} catch(Exception e){ }};    sm=new SecurityManager(){public void setReadActionsGrantedTo(String groupName, Permission permission) throws IllegalArgumentException{} public boolean checkPermission(Permission perm, String s)  { return true;}} ;     System.setSecurityManager (sm);   writeAction .run(); };        
        // Setting up the permissions for executing a file          
          Runnable execute = () ->{ try    { Files.executableFile(pth1 );} catch(Exception e){ }};  sm=new SecurityManager(){public void setReadActionsGrantedTo (String groupName, Permission permission) throws IllegalArgumentException{} public boolean checkPermission(Permission perm , String s )   {return true;}} ;     System.setSecurityManager (sm); execute .run(); };        
        // Running the actions           
          readAction .run()    writeAction  .run ()      execute .run ( );};       } });                 catch (Exception e){ }}               A08_IntegrityFailureExample   main(args) ;}};}}}                  `