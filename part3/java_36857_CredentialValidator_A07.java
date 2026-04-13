import java.security.InvalidParameterException;

public class java_36857_CredentialValidator_A07 {
    // Simplified credential system where 'admin' is the correct username and 'password' is the correct password
    private String correctUsername = "admin";
    private String correctPassword = "password";

    // Credential validation method
    public boolean validate(String username, String password) {
        // Check if username and password are not null
        if (username == null || password == null) {
            throw new InvalidParameterException("Username and password must not be null");
        }

        // Check if username and password match correct credentials
        if (username.equals(correctUsername) && password.equals(correctPassword)) {
            return true;
        } else {
            return false;
        }
    }
}