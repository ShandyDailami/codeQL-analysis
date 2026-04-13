import java.security.InvalidParameterException;
import java.util.Base64;

public class java_38210_CredentialValidator_A01 {
    // Assume that the correct username and password are used for this example
    private String expectedUsername = "admin";
    private String expectedPassword = "password";

    public boolean isValidCredentials(String username, String password) {
        // Decode the base64 password for simplicity
        byte[] decodedPassword = Base64.getDecoder().decode(password);
        String decodedPasswordStr = new String(decodedPassword);

        if (username.equals(expectedUsername) && decodedPasswordStr.equals(expectedPassword)) {
            return true;
        } else {
            throw new InvalidParameterException("Invalid username or password");
        }
    }
}