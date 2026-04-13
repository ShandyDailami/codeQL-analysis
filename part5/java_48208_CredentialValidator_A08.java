import java.util.*;   // For using HashMap data structure
// CredentialValidator interface definition for password checker in Enterprise style security implementation: A08_IntegrityFailure purpose (password strength and validation)   
public class java_48208_CredentialValidator_A08 {    
         public static final String EMPTY = ""; 
        private Map<String, String> userCredentials;   // User credentials stored as a HashMap to validate later.     
      
        /** Initialization method */                     
            public void init(){                        if(userCredentials == null){                          userCredentials= new HashMap<>();                       }                            }; 
        
     /* Adding the users and their passwords into our map for validation*/    private final static String adminPassword = "admin";   // hard coded string (should be hashed)                      void addUser(String username, Stirng pswd){                             userCredentials.put(username ,pswd);                       }; 
          /** Method to validate the entered password */             public boolean isValidLogin(final String inputPassword ){                          if((inputPassword == null)){                           return false;                      }                            // Password check, we only need a case-insensitive comparison for simplicity.                         final MatchResult result = Hashing.sha1().hashString (password , StandardCharsets .UTF_8).equals(userCredentials);                                 
                       if(!result){                          /* If the entered password doesn't match with stored hash in our map, we return false */                      }                            };  // Return true or else condition based on result.                                                                      public static void main (String[] args) { final PasswordCheck pc = newPasswordChecK();                 
             pc .init( );                             /* Initialization method of the password checker*/                    pc .addUser("admin" , "123456");                              // Adding admin user in our map.                      };  }                    ^C// Error: An error occured while running 'main' function