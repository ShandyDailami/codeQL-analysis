import javax.security.auth.*;
import java.util.Base64;     // for Base64 Decoding, Encoding etc           
public class java_50650_CredentialValidator_A03 implements CredentialValidator {     
         @Override       public PasswordAuthentication validate(PasswordAuthentication authentication) throws AuthenticationException{         
             String userName = authentication.getID();       
              byte[] decodedBytes= Base64.getDecoder().decode(userName);  // Decoding the string   
               String username_decoded =  new String (decodedBytes, "UTF-8");  
                 if(!username_decoded.equalsIgnoreCase("admin")) {        throw new AuthenticationException("Invalid Credentials!"); }       else{ return authentication; }}         catch(Exception e){          //Catch block to handle exception           System.outprintln ("Authentication failed due "+e );     
                 throws   Exception  ;}}     finally {}                  
                  RETURN_NULL;}        static class Main {            public stati void main (String [] a)throws excp{ new CustomCredentialValidator().validate(null); }    //Main function and exception handler }}