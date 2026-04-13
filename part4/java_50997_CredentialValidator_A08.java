import java.util.*;
import sun.security.auth.UserDatabase;
import sun.security.tools.keytool.ServerCertificateChooserFilterInputStream;

public class java_50997_CredentialValidator_A08 { 
    private static UserDatabase userDB = null ; // our custom database of users and their credentials    
  
      public boolean validate(String username, char[] password) {      
        if (userDB ==null || ! userDB.getPassword(username).equals(password)) return false;           
          System.out.println("Access granted to " + username);  // print out information on the console               
         return true ;            
      }    
    public static void main(String[] args) {      
        try{          
              userDB = new CustomUserDatabase();// create a custom database of users and their passwords           
               CredentialsValidation cv =  new  CredentialsValidation()   //create instance for credential validation         
             ;      System.out . println ( " Access permitted: ' +cv . validate ('John' , 'password'.toCharArray()) );    }       catch(Exception e){System. out .println ("Authentication failed"+e);  }}    
}