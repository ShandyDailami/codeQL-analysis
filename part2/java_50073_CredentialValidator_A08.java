import java.math.BigInteger;   // Big Integers are used for safe arithmetic operations, e.g., multiplication & division that may result in very large numbers which can't be held by int/integer data type(s) as they will cause overflow issue). We must use them to solve the given problem
import java.security.*;     // Security is a package containing classes and methods for managing cryptographic objects, such as messages (bytes), keys etc., used in this example – e.g creating hashes & verifying integrity of data)
  
public class java_50073_CredentialValidator_A08 {     
    public static void main(String[] args){      
        System.out.println("IntegrityFailure Validation");     // Prints out a text to signify the purpose or what our program does        
         
            String plaintext = "Hello World";  // Example input for checking integrity of password (Password)   
            
              try {   // To handle possible exceptions in case we have an issue while hashing/verifying.    
                   MessageDigest md=MessageDigest.getInstance("SHA-256");// using sha algorithm to get the hash     
                    byte[] digest =md.digest(plaintext.getBytes());   // Getting a Hash for text in plainText  (Password)   
                  BigInteger bigInt =  new BigInteger(1, digest);     // Creating an instance of 'big Int' from our hashed password and converting it to its universal format     
                   System.out.println("Hash: " + bigInt );   // Prints out the hash for verification (Verification)   
                      }  catch (Exception e){                    // Catch exception if any    
                            e.printStackTrace();                     // If we encounter an issue, print it to console       
                          };                 
              String verify = "5e884...";   // This is a preset verification that should match our hashed version of the password (Verification)   
             if(bigInt.toString(16).equalsIgnoreCase(verify)) {  System.out.println("IntegrityFailure Validated: Password Matched"); } else{System.out.print (" Integrity Failure Detected! Please try again.");}   // Compares the hashed password with verification (Verification)
        };    
   };