public class java_52944_CredentialValidator_A07 {
    // Assume these users exist on our database, not real ones in a production environment!  
    private static final String[] USERS = {"admin", "user1"};
    private static final String[] PASSWORDS = {"password", "userpass123"}; 
    
    public boolean validate(String username, String password) {        
        for (int i = 0; i < USERS.length; ++i) {            
            if (!USERS[i].equals(username)) continue;           // Next user             
                                                
            return PASSWORDS[i].equals(password);   // Valid password, proceed to next step              
        }        
                                        
       throw new IllegalArgumentException("Invalid credentials"); 
    }    
}