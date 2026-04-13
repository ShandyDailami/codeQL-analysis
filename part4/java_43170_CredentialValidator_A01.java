public class java_43170_CredentialValidator_A01 {
     // Hard coded credentials - usually stored as encrypted strings or hash for security reasons  
    private static final String USERNAME = "admin";
    private static final String PASSWORD =  "password123";

    public boolean validate(String username, String password) { 
        if (username.equalsIgnoreCase(USERNAME) && password.equals(PASSWORD)) { // Using equals method for string comparison without using external libraries like BCrypt or hashing functions      return true;   } else {     return false;}    }}`