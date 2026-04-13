import java.security.InvalidParameterException;

public class java_01090_CredentialValidator_A07 {
    // Validates a username and password.
    // If the credentials are valid, it returns true, otherwise, it throws an InvalidParameterException.
    public boolean validate(String username, String password) {
        // This is a simple validation. In a real-world application, you'd probably want to use a secure hash algorithm for the password.
        if (username == null || username.isEmpty()) {
            throw new InvalidParameterException("Username cannot be null or empty");
        }
        if (password == null || password.isEmpty()) {
            throw new InvalidParameterException("Password cannot be null or empty");
        }
        
        // Place your actual validation code here.
        // For example, you might check if the username and password match a hard-coded set of valid credentials.
        if (username.equals("admin") && password.equals("password")) {
            return true;
        } else {
            return false;
        }
    }
}