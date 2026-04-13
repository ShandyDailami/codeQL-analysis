import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_04121_CredentialValidator_A03 {

    // HashMap to hold username and password pairs
    private Map<String, String> credentials;

    // Constructor
    public java_04121_CredentialValidator_A03() {
        this.credentials = new HashMap<>();
        // Add some default credentials
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
    }

    // Method to validate credentials
    public boolean validate(String username, String password) {
        // Decoding the password
        byte[] decodedPassword = Base64.getDecoder().decode(credentials.get(username));
        String decodedPasswordString = new String(decodedPassword);

        // Validate password
        return decodedPasswordString.equals(password);
    }
}