import java.io.*;   // Import required classes 
import java.security.*;     // For handling security operations (FilePermissions)   
      
public final class java_43279_FileScanner_A01 {     
         public static void main(String[] args){        if(!args[0].equals("-d")){            System.out.println("\n Usage: JDK_MainDir -dir <directory>");           return;   }  // check whether argument is a directory       SecurityManager sm = new SecurityManager(){     @Override    public boolean getSecurityPermission(Permission perm) {      if (perm instanceof FilePermission){          String n = ((FilePermission) perm).getName();         try{        System.out.println("\n Reading file: "+n); //Reading the content of a specific