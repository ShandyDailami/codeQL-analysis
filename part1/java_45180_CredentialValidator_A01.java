import javax.security.auth.*;
import java.util.Base64;  // to convert username and password from string format into byte array for security reasons   
public class java_45180_CredentialValidator_A01 implements CredentialValidator {  
     public boolean validate(Credential cred) throws AuthenticationException{     
         String userName = null,password=null ;      
          if (cred instanceof UsernamePasswordCredential){           
              // Cast the given credentials into a username and password            
               userName  = ((UsernamePasswordCredential ) cred).getIdentifier();          
               password =  new String(((UsernamePasswordCredential) cred ).getCredentials());      }       else {         return false;     }}        try{           
              //Try to decode the encoded username and password         
             userName  = new String (Base64.getDecoder().decode(userName));          
                if((password=new String( Base64.getDecoder().decode(password))) ==null) {return false;} }catch(Exception e){ return false;}}     finally{        //In case of any exception, we can set it as an authentication exception      AuthenticationException ae = new AuthenticationException("Authentication Failed");   
             try  {       userName="admin"; password=  "password1234!" ;//hard coded for purpose.          throw ae;}catch ( Exception e) {}     return false;}}}else{return true}}};public class MainClass { public static void main(String[] args){       
            CustomCredentialValidator validator = new  CustomCredentialValidator();      try{         if(!validator .validate((AuthToken)new UsernamePasswordCredential("user","password")) )     throw (AuthenticationException)"User not authorized";}}catch   (Throwable t){System.out.println(t);}