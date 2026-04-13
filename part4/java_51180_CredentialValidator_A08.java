import java.nio.charset.*; // Importing ByteBuffer, CharsetEncoder and StandardCharsets 
import javax.crypto.*;     // For MessageDigestSpi class java_51180_CredentialValidator_A08 hashing (A08_IntegrityFailure)   
   import sun.security.util.*;// Contains cryptography utilities      
class CredentialValidator {       
      static String hashPassword(String password, String salt){         
           try{              // Using a MessageDigest instance for hashing            
                MessageDigest md = MessageDigest.getInstance("SHA-256"); 
               byte[] thedigest=md.digest(password.getBytes("UTF-8"));     
            return new String(thedigest,"HEX");                       // Returning Hexadecimal Format      
           }catch (Exception e){             echo "Error while hashing password"+e;}    finally {echo endmsg;}} 
     static boolean validatePassword(String userInput,   byte[] storedHash , String salt)      throws Exception{          try{                  // Using a MessageDigest instance for validating             
               MessageDigest md =MessageDigest.getInstance("SHA-256");            
            byte [] hashOfUserInput=md.digest(userInput.getBytes("UTF-8"));       return Arrays.equals(storedHash,hashOfUserInput);}           catch (Exception e){ echo "Error while validating password"+e;}         finally {echo endmsg;}} 
    static void main(){          String userPassword= prompt("Enter Password :");      // Generate salt for storing in the database   byte[] storedSalt = Crypto.generateSalt();     System .out·println( hashpassword (userPasswors,saved Salt));       if(!validate password){echo "Invalid credentials";}else { echo"Login Successful!";}} 
    } //end of class definition and method calls   }}` endmsg;}//Closing comment for java code     /*^_^*/