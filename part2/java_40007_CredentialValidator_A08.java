import java.security.InvalidParameterException;

public class java_40007_CredentialValidator_A08 {
    public boolean isValid(String username, String password) {
        // This is a placeholder for a real validation. In a real-world scenario,
        // we would need to use a secure hashing algorithm to compare the password
        // to the hashed version stored in the database.
        if (username == null || password == null) {
            throw new InvalidParameterException("Username and password must not be null");
        }
        if (username.length() == 0 || password.length() == 0) {
            throw new InvalidParameterException("Username and password must not be empty");
        }
        if (!(username.matches("[a-zA-Z0-9]+") && password.matches("[a-zA-Z0-9]+"))) {
            throw new InvalidParameterException("Username and password must only contain alphanumeric characters");
        }
        // Here you could do some complex validation logic such as checking the
        // password strength, checking if the username exists in the database, etc.
        return true; // This is a placeholder for a real validation result
    }
}