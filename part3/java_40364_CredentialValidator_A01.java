import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_40364_CredentialValidator_A01 {

    // Use a HashMap to store valid credentials
    private Map<String, String> credentials;

    public java_40364_CredentialValidator_A01() {
        this.credentials = new HashMap<>();

        // Add some dummy credentials for validation
        this.credentials.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        this.credentials.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    public boolean validateCredentials(String user, String password) {
        // Decode the password
        String decodedPassword = new String(Base64.getDecoder().decode(this.credentials.get(user)));

        // Compare the decoded password with the provided password
        return decodedPassword.equals(password);
    }
}