public class java_47247_CredentialValidator_A07 {  
    // Method that validates the given credential: Username and password    
    public static boolean validate(String username, String password) throws Exception{          
        if ("user".equalsIgnoreCase(username)) {                
            return true;            
        } else {               
            throw new AuthFailureException();  // If credentials are incorrect then an exception is thrown to indicate fail-login.  
        }   
     }     
}