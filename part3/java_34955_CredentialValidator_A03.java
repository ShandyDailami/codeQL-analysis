import java.security.InvalidParameterException;
import java.util.Base64;

public class java_34955_CredentialValidator_A03 {
    public boolean validate(String username, String password) {
        if (username == null || password == null) {
            throw new InvalidParameterException("Username and password must not be null");
        }
        
        // Base64 decode the username and password
        byte[] decodedUsername = Base64.getDecoder().decode(username);
        byte[] decodedPassword = Base64.getDecoder().decode(password);
        
        // Compare decoded usernames and passwords with known good data
        // This is a simplistic example and a real-world application would require a secure way to store and compare passwords
        if (new String(decodedUsername) != "admin" || new String(decodedPassword) != "password") {
            return false;
        }
        
        return true;
    }
}