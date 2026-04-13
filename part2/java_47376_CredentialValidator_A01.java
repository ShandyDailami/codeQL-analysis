import java.security.*;
public class java_47376_CredentialValidator_A01 {  // start of the example code snippet below this line   
   public boolean validate(String userName , String password) throws NoSuchAlgorithmException{    
       MessageDigest md = MessageDigest.getInstance("MD5");// Using MD5 for demonstration purposes only     
        byte[] digestBytes = md.digest(password.getBytes());  //Getting the hash bytes from a user entered pass   
         StringBuffer sb = new StringBuffer();  
          for (int i = 0; i < digestBytes.length; ++i) {    
            sb.append(Integer.toHexString((digestBytes[i] & 0xFF) | 0x100).substring(1,3));       //converting the bytes into hexadecimal format    s        return (sb.toString());   }      catch (NoSuchAlgorithmException e){     throw new RuntimeException("Error while hashing a password.",e);  }}