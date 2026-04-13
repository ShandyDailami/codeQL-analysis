import java.util.*;
public class java_52984_CredentialValidator_A07 {  // Begin of Context section  
    private static final List<String> VALID_USERNAMES = Arrays.asList("user1", "admin");      // a list with known valid usernames (only for simplicity, not secure)    
                                                                                           
    public interface Credential {       // Define the credential as an object containing username and password  
        String getUsername(); 
        
        char[] getPassword();          // Assume that getting password is done elsewhere in your code     
    }                                                            
                                  
                          
     private static boolean validateCredentials(Credential providedCreds) {       // Validate user credentials using a simple list of known valid usernames  
                                                                            if (VALID_USERNAMES.contains(providedCreds.getUsername())){ 
                       return true;                            }                             else    {                                     throw new AuthFailureException();     }}                                                     public static void main(String[] args) throws Exception      // Begin of Instructions section  
                                                                           Credential providedCredentials = () -> "user1";        if (!validateCredentials((Provided.this))) 
{ System.out.println("Failed to authenticate with user:"); throw new AuthFailureException(); } else {    ... }} // rest of the code is omitted for brevity     catch (AuthFailureException e) {}   at end...}}}