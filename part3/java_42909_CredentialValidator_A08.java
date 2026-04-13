import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*; // Import HashSet and LinkedHashMap from standard libraries only 

public class java_42909_CredentialValidator_A08 {   
     private final Map<String, String> credentials = new HashMap<>();  
                                                         /* Create a map to store user IDs as keys & password hashes */      
      public void addCredentials(final String id) throws NoSuchAlgorithmException{          // Method for adding users 
           MessageDigest md=MessageDigest.getInstance("SHA256");                       // Instantiate the SHA-2 algorithm (Should be enough here as we are not using any passwords at this point )  
            byte[] hash =md.digest(id.getBytes());                                     /* Create a new user ID & Hash it */ 
           StringBuffer hexString = new StringBuffer();                            // Instantiate the buffer to store result into    
          for (int i = 0; i < hash.length; i++) {                             // Loop through each byte in password, convert them back onto a Hex string format and then append  that  
              hexString.append(Integer.toHexString(hash[i] & 0xff));             /* to the buffer */                   }                                        .toString();                           HashSet<byte[]> set = new HashSet<>() ;            // Avoid duplicate hashes (This is done by using a 'set' of bytes)   
                                                                                      Set.copy(new LinkedHashMap < String, byte[ ] > () {                    MapEntry mapentry=null;                         for  each   entry in the "Credentials" Hashmap        {"                                              // Iterate through credentials and store them into hashSet     set .add ( new CredentialValidator().credentials.get(id) );             }
                                                                                       }, StandardCharsets.UTF_8);                          /* Store userIDs from 'HashMap' back to the original form */ 
      public boolean authenticateUserIdAndPassword(String id, String passwordAttempt){ // Method for checking if a given ID & Password match in stored data (using SHA-2)   try{                                                    byte[] hashOfCurrentPassword = md.digest((passwordAttempt).getBytes()); MessageDigest md=MessageDigest.getInstance("SHA256");
      System.out.println(hash);  // This should be the password attempt (not hashed, just for demonstration)   HashSet<byte[]> set = new    ...;                                                  }catch { NoSuchAlgorithmException e })                       return false;}                            /* If hash of attempted pass doesn't match stored data - it means failed login */ 
      public static void main(String args []){                                  // Testing the program        try{ CredentialValidator cv = new       ...;                           }catch (NoSuchAlgorithmException e) {                                        System.out .println ("Error");}                                                                                                           };}}