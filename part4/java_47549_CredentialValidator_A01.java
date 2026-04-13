import java.security.*;
// ... import other necessary classes needed such as MessageDigest, SecureRandom etc...  

public class java_47549_CredentialValidator_A01 {    // Start with a proper name    
         public boolean validate(String username, String password) throws NoSuchAlgorithmException 
        /* Define the function to check if given credentials are valid. */{      
            MessageDigest md = MessageDigest.getInstance("MD5");   // Use an instance of MD5 for hashing pass    
             byte[] hashPassword  = md.digest(password);          // Get a digest (hash) from the password   
              StringBuilder sb = new StringBuilder(); 
            for (byte b : hashPassword){                        // Appending each byte in hexadecimal format  
                sb.append(String.format("%02x", b));             // To form strings of Hexa Decimal Format    
            }          
         /* Convert the string to a normal String and then compare it with given password */ 
          return (sb.toString().equalsIgnoreCase((username)));      }) ? true : false;    });   }}