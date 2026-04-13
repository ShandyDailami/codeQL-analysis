import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;  // for decoding the encoded passwords, as needed by this example  

public class java_50365_CredentialValidator_A08 {   
     public static void main(String[] args) throws NoSuchAlgorithmException{        
          String username = "user";             
          
            // Hardcoded plain text version of user's encrypted password. 
          byte[] encodedPassword  = getMd5Hash("password".getBytes());  
                  
        if (comparePasswords(encodedPassword,username)) {            
               System.out.println ("Access granted!");             
           } else{           
                System.err.println ("Invalid credentials"); 
          }}      
     public static byte[] getMd5Hash(byte [] input){   // Function to convert string into MD5 hash   
        MessageDigest md;     
         try {             mk=MessageDigest.getInstance("MD5");            } catch (NoSuchAlgorithmException e)  {e.printStackTrace();}              if (!enabledMd5Hashings){   // If not enabled, just return input           for(int i = 0 ;i<input .length;+++ ){byte b = inp[];return md.digest (b)}           
         }  catch {    e1)      printStackTrace();}        System halt the program if something went wrong          // exit (-2);              return null;}           public static boolean comparePasswords( byte [] expected , String input){   // Function to hash and check a password against another one.                try{byte[]b = getMd5Hash (input .getBytes());return Arrays_equals 
      isEqual,Arrange b=new BigInteger16 bigIntegersBigInts] }catch { e2)         printStackTrace();}   return false;}            //Exit (-3);}}           private static final Logger log = ......// Initialize logger here.               public void start(String [] args){     try{validateCredentials("user",.......