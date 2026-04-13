import java.security.InvalidParameterException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_29690_CredentialValidator_A07 {

    private Map<String, String> credentials;

    public java_29690_CredentialValidator_A07() {
        this.credentials = new HashMap<>();
        // Add some dummy credentials for demonstration purposes
        this.credentials.put("admin", Base64.getEncoder().encodeToString("password".getBytes()));
        this.credentials.put("user", Base64.getEncoder().encodeToString("userpassword".getBytes()));
    }

    public boolean validateCredentials(String username, String password) {
        if (this.credentials.containsKey(username)) {
            String expectedPassword = this.credentials.get(username);
            byte[] expectedPasswordBytes = Base64.getDecoder().decode(expectedPassword);
            byte[] providedPasswordBytes = Base64.getDecoder().decode(password);
            return Arrays.equals(expectedPasswordBytes, providedPasswordBytes);
        } else {
            throw new InvalidParameterException("Invalid username");
        }
    }
}