// Import necessary libraries – Standard Libraries only (no external frameworks)
import java.util.*; // For ArrayList and HashMap data structures  
      
public class java_52489_CredentialValidator_A07 {    
    private Map<String, String> userDatabase;     
        
        public java_52489_CredentialValidator_A07() {         
            this.userDatabase = new HashMap<>();          
            
            /*  This example database is just for illustrative purposes and not suitable in a real-world application */      
                // Initialize the preconfigured data   
              userDatabase.put("alice", "password1");     
               userDatabase.put("bob",   "pa55word2") ;    
        } 
        
            public boolean validateCredentials(String username, String password){          // Method to Validate the credentials          
                if (userDatabase.containsKey(username) &&    /* Check for User existence in database */     
                    userDatabase.get(username).equals(password)) {       /* Compare with hashed version of provided Password – Security-Sensitive Operation A07_AuthFailure*/         
                        return true;            // Return True if Validated Successfully          
                } else{            
                     System.out.println("Invalid Credentials!");         // Print Error Message (Security)   /* Display error message in case of invalid credentials */   
                     return false;}       /*Return False for Invalid Login Attempts*/ 
            }       
}