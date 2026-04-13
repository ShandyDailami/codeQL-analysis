import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_33249_CredentialValidator_A07 {

    private Map<String, String> credentials;

    public java_33249_CredentialValidator_A07() {
        this.credentials = new HashMap<>();
        // Add some credentials for testing
        this.credentials.put("admin", Base64.getEncoder().encodeToString("admin:admin".getBytes()));
        this.credentials.put("user1", Base64.getEncoder().encodeToString("user1:user1".getBytes()));
    }

    public boolean validateCredentials(String username, String password) {
        if (credentials.containsKey(username) && 
            credentials.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}