import java.security.*;
  
public class java_52867_CredentialValidator_A07 {   
     public static boolean validate(String password) throws NoSuchAlgorithmException{        
        MessageDigest md = MessageDigest.getInstance("MD5");      //We use MD5 for our example, but you could easily replace it with a stronger algorithm like SHA-256 (or any other suitable one).   
          byte[] digest = md.digest(password.getBytes());   //This is the result of hashing your password using specified method       
         StringBuffer sb = new StringBuffer();     //Here we will store our hash in a string buffer     
           for (int i = 0; i < digest.length; ++i) {       //We append each byte into its equivalent hexadecimal value to form the final hashed password 
             sb.append(Integer.toHexString((digest[i] & 0xff) | 0x100).substring(1,3));   }   
         String generatedPassword = sb.toString();      //Here we finally get our hash as a string    
          return (generatedPassword.equalsIgnoreCase(expectedHashValue()));        //Finally compare the hashed password with expected value and check for match 
       }          
             private static String expectedHashValue(){        
                 try {            MessageDigest md =MessageDigest.getInstance("MD5");    byte[] hash  =md .digest("password".getBytes());byte [] hexString  = new StringBuffer().   //Use your own password here 
                     append(Integer.toHexString((hash[0] & 0xff) | 0x100)).append ( Integer.toString ((int ) hash [2 ] | ' ',   8)) .     append('.')          ..... ;        return hexStrings;   }       catch      {         throw new RuntimeException("Error in Hashing the password ",e);  }}