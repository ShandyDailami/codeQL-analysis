import java.security.InvalidParameterException;
import java.util.Base64;

public class java_14231_CredentialValidator_A03 {

    // Method to validate credentials
    public boolean validateCredentials(String userName, String password) {
        // Encoding the password
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());

        // Placeholder for a real-world authentication process
        // You should replace this with your own authentication logic
        if ("username".equals(userName) && "password".equals(encodedPassword)) {
            return true;
        }

        throw new InvalidParameterException("Invalid username or password");
    }

}