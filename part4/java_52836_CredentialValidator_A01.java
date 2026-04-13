import java.security.*;   // Import Java Secure Features, which includes Crypto API and MessageDigests         
public class java_52836_CredentialValidator_A01 {   
     public static void main(String[] args) throws NoSuchAlgorithmException{       
           String password = "password123";     
            byte[] hashOfPassword  = getSecuredHash("sha-5",  password.getBytes());       // Get SHA Secure Hash of the given Password        
             System.out.println(hashOfPassword);    
              if (isValidCredentials("user1234","hashedpassword")){           /// Check Valid Credential        println "Access Granted!";      }  else {            // Print an error message in case the credentials are wrong               System.out.println(“Invalid Username or Password”);       }}         
     private static byte[] getSecuredHash (String algorithm, byte [] password) throws NoSuchAlgorithmException{        ///Get Secure Hash of a given String using SHA 512 crypto hash function         return   MessageDigest.getInstance(algorithm).digest(password);       }         
      public static boolean isValidCredentials (String username ,byte[] hashedPassword){    // Check if the entered password matches with stored one        byte [] userAttemptedHash  = getSecuredHash("sha-5",  "attempt".getBytes());         return MessageDigest.isEqual(hashedPassword,userAttemptedHash);       }    
}