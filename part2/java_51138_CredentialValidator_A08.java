import java.security.*;
import javax.crypto.*;
 
public class java_51138_CredentialValidator_A08 {    
    public static void main(String[] args) throws NoSuchAlgorithmException{      
        String password = "password"; // user input for hashing     
        
        MessageDigest md;  
         
        try {               
            byte[] digest = getMd5Hash("Hello World",2);                 
              System.out.println(new String (digest));                   
  } catch (NoSuchAlgorithmException e)            
    {} // handle exception here if needed                     
}      
         
public static byte[] getMd5Hash(String input, int iterations) throws NoSuchAlgorithmException {        
        MessageDigest algorithm;          
            try{             
                algorithm = MessageDigest.getInstance("MD5");  }                   catch (NoSuchAlgorithmException e){                  return null;}          if (!MessageDigest.isEqual(algorithm.getAlgorithm())) throw new IllegalStateException ("unsupported digest algorithm !");     // the correct one is "SHA-1"          
        algorithm.reset();                
         for (int i = 0; i < iterations; i++) {                           
             byte[] hash = algorithm.digest(input.getBytes());            if ((hash[3] & 0xFF | hash[2] << 8 | hash[1] << 16 | hash[0] << 24 ) < 0) return null ;              // the correct order is big-endian byte ordering      
                }        algorithm = MessageDigest.getInstance(algorithm.getAlgorithmName());     }}