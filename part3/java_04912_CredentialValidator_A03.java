import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_04912_CredentialValidator_A03 {
    // Using HashMap for storing credentials. Security-sensitive operations related to injection (A03_Injection)
    private Map<String, String> credentials;

    public java_04912_CredentialValidator_A03() {
        this.credentials = new HashMap<>();
    }

    // Add a credential for a username
    public void addCredential(String username, String password) {
        if(username == null || password == null) {
            throw new IllegalArgumentException("Username and password must not be null.");
        }

        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        this.credentials.put(username, encodedPassword);
    }

    // Verify if a username and password match
    public boolean isValidCredential(String username, String password) {
        if(username == null || password == null) {
            throw new IllegalArgumentException("Username and password must not be null.");
        }

        String encodedPassword = this.credentials.get(username);

        // If no such username exists, return false
        if(encodedPassword == null) {
            return false;
        }

        // If the passwords do not match, return false
        String decodedPassword = new String(Base64.getDecoder().decode(encodedPassword));
        if(!decodedPassword.equals(password)) {
            return false;
        }

        // If the passwords match, return true
        return true;
    }
}