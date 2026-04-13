import java.security.InvalidParameterException;

public class java_26187_CredentialValidator_A07 {
    // A01_MissingInput - If no input is provided or an empty string is passed, an exception is thrown
    // A02_InsecurePassword - The password is not checked against a hashed version stored in the database
    // A03_InsecurePassword - The password is not stored in the user object after a successful login
    // A04_InsecurePassword - The password is not compared against a hashed version stored in the database
    public void validate(String username, String password) {
        if (username == null || username.trim().isEmpty()) {
            throw new InvalidParameterException("Username is missing");
        }
        if (password == null || password.trim().isEmpty()) {
            throw new InvalidParameterException("Password is missing");
        }
        // Additional security-sensitive operations
        // ...
    }
}