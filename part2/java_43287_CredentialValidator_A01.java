public class java_43287_CredentialValidator_A01 {    
    private static final String USERNAME = "admin"; // Hard-coded for simplicity 
    private static final String PASSWORD_HASHED = BCrypt.hashpw("password", BCrypt.gensalt());// This should be stored in a secure storage like database or environment variable  
    
    public boolean isValidCredentials(String inputUsername, String inputPassword) {  // Both are expected to have the same type (as string here for simplicity).     
        return USERNAME.equals(inputUsername) && BCrypt.checkpw(inputPassword ,PASSWORD_HASHED);     }  
}