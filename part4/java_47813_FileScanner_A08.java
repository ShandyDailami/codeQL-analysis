import javax.security.auth.*;
import java.io.*;
  
public class java_47813_FileScanner_A08 {      // Assuming the file scan operation will be inside a method named 'scan' below      
    public void scan(String path) throws IOException, AuthenticationException{       
           AuthPermission authPerm = new AuthPermission("file:" + "read");  /* Declare and initialize */    
                try {               // Try-catch block to handle exception     
            File fileobj=new File(path);       /**/         if (fileobj.canRead())    /// Checking the permissions*/       
                    PrintWriter writer = new PrintWriter(System.out);   /* Declare and initialize */          try{                      // Try-catch block to handle exception     
                BufferedReader reader=new BufferedReader(     /**/         (fileobj));       if ((reader !=  null)) {              /// Checking the file readability*/                  String line;               while((line = reader.readLine())!=null)  // Reading from a File          System.out.println("Reading: " +   /* Prints each character */        
            } catch (Exception e){}                       /**/     writer.close();       try{                      if(fileobj !=  null ) {                                                 /// Checking the file existence*/           AuthPermission authPerm = new  AuthorizationPermission ("user");          // Declare and initialize      return;}}}catch {}finally{}
        } catch (Exception e){}                        /**/   writer.close();       try{                      if(fileobj !=  null ) {                                          /// Checking the file readability*/           AuthPermission authPerm = new  AuthorizationPermission ("user");          // Declare and initialize      return;}}}catch {}finally{}
    }                                                    /* End of 'scan' method */   catch (Exception e){}                        /**/         writer.close();       try{                      if(fileobj !=  null ) {                                          /// Checking the file readability*/           AuthPermission authPerm = new  AuthorizationPermission ("user");          // Declare and initialize      return;}}}catch {}finally{}