import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_38486_CredentialValidator_A07 {

    private Map<String, String> credentials;

    public java_38486_CredentialValidator_A07() {
        this.credentials = new HashMap<>();
        // Add some dummy credentials
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
        this.credentials.put("user3", "password3");
    }

    public boolean validate(String username, String password) {
        // Encoding the password for comparison
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());

        // Validate the credentials
        if (this.credentials.containsKey(username) && 
            this.credentials.get(username).equals(encodedPassword)) {
            return true;
        }
        return false;
    }
}