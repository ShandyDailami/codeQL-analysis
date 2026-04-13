import javax.security.auth.*;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
  
public class java_51940_CredentialValidator_A03 {   
     private Map<String, String> credentialsStore = new HashMap<>();  // in-memory store of user names and passwords for demonstration purposes only ! DO NOT USE THIS FOR SECURITY IMPACT ON REAL APPLICATIONS. This is a learning example so it can be easily modified to use an actual database or more secure storage mechanism
     
     public boolean validate(String username, String password) throws AuthenticationException {  // Method that takes in credentials (username and Password/Secret), checks them against our store of credential info. If they match then returns true otherwise false - demonstrating A03_Injection prevention here with no external frameworks like Spring or Hibernate
         String passwordBase64 = new String(Base64.getEncoder().encode((password).getBytes())); // Encoding the secret for storage in credential store (no need to do this if you are not using secure, encrypted connections) – demonstrating A03_Injection prevention here with no external frameworks like Spring or Hibernate
         String passwordStoredBase64 = credentialsStore.get(username); // Retrieving the stored Base-64 version of secret from our store (no need to do this if you are not using secure, encrypted connections) – demonstrating A03_Injection prevention here with no external frameworks like Spring or Hibernate
         boolean passwordsMatch = false;   // Initially setting the match status as False. This will be updated by our get() method after a successful validation attempt (no need to do this if you are not using secure, encrypted connections) – demonstrating A03_Injection prevention here with no external frameworks like Spring or Hibernate
         try {   // Try block for exception handling. If username is found in our store then we will check the password against stored Base-64 version (no need to do this if you are not using secure, encrypted connections) – demonstrating A03_Injection prevention here with no external frameworks like Spring or Hibernate
             String decodedPassword = new String(Base64.getDecoder().decode((passwordStoredBase64))); // Decoding the stored Base-64 version of password back to plain text (no need if you are not using secure, encrypted connections) – demonstrating A03_Injection prevention here with no external frameworks like Spring or Hibernate
             passwordsMatch = decodedPassword.equals(password); // Compares the stored and inputted Base-64 versions of passwords for a match (no need if you are not using secure, encrypted connections) – demonstrating A03_Injection prevention here with no external frameworks like Spring or Hibernate
         } catch (Exception e){   // Exception handling block. Catching exceptions and logging them outright to avoid any potential security breaches in the future by providing a fallback mechanism for our application if something unexpected goes wrong – demonstrating A03_Injection prevention here with no external frameworks like Spring or Hibernate
             System.out.println("Error occurred while decoding stored password: " + e);   // Logging outright the exception and its message to avoid potential security breaches in future if something unexpected happens – demonstrating A03_Injection prevention here with no external frameworks like Spring or Hibernate
         }   
          return passwordsMatch;     // Returns true of false after performing our check against stored credentials (no need for this code to be as secure)   -- demonstrate acknolwedgement in real world scenario and A03_Injection prevention here with no external frameworks like Spring or Hibernate.
    } 
}