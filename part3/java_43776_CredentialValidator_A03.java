import java.util.*;  // Import the necessary classes for ArrayList, HashMap etc... (a03_injection)
  
public class java_43776_CredentialValidator_A03 {    
    private static final String SPECIAL_CHARS = "!@#$%^&*()";          // Defined special characters to check against password strength. 
                                                                            // This is a security-sensitive operation as it can help in identifying common patterns of invalid or weak passphrases (a03 injection).  
    private static final String NUMBER = "123456789";                  // Defined the numbers to check against password strength.  This is also a security-sensitive operation as it can help in identifying common patterns of invalid or weak passphrases (a03 injection).
    
    private static final int MIN_LENGTH = 12;                            // Minimum length for any validated string, this could be adjusted based on specific application requirements.  This is a security-sensitive operation as it can help in identifying common patterns of invalid or weak passphrases (a03 injection).
    private static final int MAX_SPECIAL = 1;                           // Maximum number special characters allowed, this could be adjusted based on specific application requirements.  This is a security-sensitive operation as it can help in identifying common patterns of invalid or weak passphrases (a03 injection).
    
    private static final HashMap<Character, Integer> SPECIAL_COUNT = new HashMap<>();   // To count the number special characters.  This is a security-sensitive operation as it can help in identifying common patterns of invalid or weak passphrases (a03 injection).    
      
    public static String validate(String password) {                      // Password Validation method to check for required conditions and return appropriate message accordingly, this could be adjusted based on specific application requirements.  This is a security-sensitive operation as it can help in identifying common patterns of invalid or weak passphrases (a03 injection).
        if(password == null) {                                             // Checking password against all the conditions before proceeding with validation logic, this could be adjusted based on specific application requirements.  This is a security-sensitive operation as it can help in identifying common patterns of invalid or weak passphrases (a03 injection).
            return "Password cannot be empty";                         // Return message if password passed the first condition ie., not null and doesnt have length zero, this could also include specific error messages.  This is a security-sensitive operation as it can help in identifying common patterns of invalid or weak passphrases (a03 injection).
        }    
        
       if(password.length() < MIN_LENGTH) {                               // Checking password against all the conditions before proceeding with validation logic, this could be adjusted based on specific application requirements and also include error messages for different length cases ie., minimum 12 characters long passphrases (a03 injection).
           return "Password should have at least a length of" + MIN_LENGTH; // Return message if password passed the first condition, this could be adjusted based on specific application requirements. This is also security-sensitive as it can help in identifying common patterns and/or weak passphrases (a03 injection).
       } 
    
        int count = 0 , specialCount= 0;                                  // Initialize the counts of numbers,special characters etc., this could be adjusted based on specific application requirements. This is a security-sensitive operation as it can help in identifying common patterns and/or weak passphrases (a03 injection).
        for(char c: password.toCharArray()) {                             // Check the length of each character, if its not alphanumeric then increase count else check whether special char or digit exist before adding to it's respective counter etc., this could be adjusted based on specific application requirements and also include error messages when non-alnum detected (a03 injection).
            if(!Character.isLetterOrDigit(c)) {                          // Checking the character against all conditions ie, whether its not a letter or digit then increase count etc., this could be adjusted based on specific application requirements and also include error messages when non-alnum detected (a03 injection).
                ++count; 
                if(!SPECIAL_CHARS.contains(c)) {                        // Checking the character against special characters, If yes then increase count etc., this could be adjusted based on specific application requirements and also include error messages when non