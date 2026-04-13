import java.security.InvalidParameterException;
import java.util.Base64;

public class java_09092_CredentialValidator_A01 {
    public static boolean isValid(String username, String password) {
        // A real-world example would handle encoding and decoding of the password,
        // checking against some encrypted database, etc.
        // This is just a simplistic example that would not be secure.

        // Ensure the username and password are not empty.
        if (username == null || password == null) {
            throw new InvalidParameterException("Username and password must be provided.");
        }

        // Ensure the username and password are not too long.
        // In a real-world application, you would likely want to handle this more gracefully.
        if (username.length() > 20 || password.length() > 20) {
            throw new InvalidParameterException("Username and password must be less than 20 characters.");
        }

        // This is a very simple method of checking if a string is in base64.
        // In a real-world application, you would likely want to use a more secure method.
        try {
            new String(Base64.getDecoder().decode(username), "UTF-8");
            new String(Base64.getDecoder().decode(password), "UTF-8");
        } catch (Exception e) {
            throw new InvalidParameterException("Invalid username or password.", e);
        }

        // If we've made it this far, the username and password are valid.
        return true;
    }
}