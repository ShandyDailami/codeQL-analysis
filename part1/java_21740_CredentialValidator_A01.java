import java.security.InvalidParameterException;

public class java_21740_CredentialValidator_A01 {

    // A simple username-password validation
    public boolean validate(String username, String password) {
        if (username == null || username.length() == 0) {
            throw new InvalidParameterException("Username is null or empty");
        }
        
        if (password == null || password.length() == 0) {
            throw new InvalidParameterException("Password is null or empty");
       
        // The real validation is done here...
        // This is a dummy validation.
        return true; // replace with actual validation logic.
    }
}