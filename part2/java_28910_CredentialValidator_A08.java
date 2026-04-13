import java.security.InvalidParameterException;

public class java_28910_CredentialValidator_A08 {
    public boolean validate(String username, String password) {
        if (username == null || password == null) {
            throw new InvalidParameterException("Username and password must not be null");
        }

        // Simulating a real-world integrity failure by not checking password length
        if (password.length() <= 4) {
            throw new InvalidParameterException("Password length must be greater than 4");
        }

        // If we got here, the credentials are valid, return true
        return true;
    }
}