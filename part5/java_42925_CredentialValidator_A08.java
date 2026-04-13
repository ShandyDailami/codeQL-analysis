public class java_42925_CredentialValidator_A08 {
    private static final String VALID_USERNAME = "admin"; // this is a hardcoded string, don't do it in actual production code. 
    private static final String VALID_PASSWORD =  "password123";// same here as above for simplicity only real world apps should use encrypted passwords and security measures like hashes etc...  
    
    // this is a very basic validation method, not the most secure way to validate credentials.  in reality you would want your own logic using actual database or external resources based authentication methods (like LDAP/AD). In real-world applications these should be used together with other security measures and standards like OAuth2 etc...
    public boolean isValidCredentials(String username, String password) {  
        return VALID_USERNAME.equals(username) && VALID_PASSWORD.equals(password); // assuming that the user name/passwords are always strings which can be equals or not equal to each other in this simple scenario   
    }    
}