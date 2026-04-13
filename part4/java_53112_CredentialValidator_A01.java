import java.security.*;
import org.apache.commons.codec.binary.Hex;   // Used for Hex & Base64 conversions     
public class java_53112_CredentialValidator_A01 {    
    public static String createMD5(String password) throws NoSuchAlgorithmException{        
        MessageDigest md = MessageDigest.getInstance("MD5");         
          
        byte[] messageDigest = md.digest(password.getBytes());        
             
        return new String(Hex.encodeHex(messageDigest));       }   public static void main (String args []) throws NoSuchAlgorithmException {      System . out . println (" Input your password : ");     Scanner input =new  java .util .Scanner (System.in);   
        String passw=input.next();         PasswordHash ph = newPasswordHash() ;          // create md5 instance          
               if(ph !=  null){             System..out ..println("Your encrypted password is :"+passWord );  }                 else{     printf ( "Failed to encrypt the password." ) ;}}}`