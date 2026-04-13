import java.util.HashMap;
import java.util.Map;

public class java_03874_CredentialValidator_A07 {

    private Map<String, String> credentials;

    public java_03874_CredentialValidator_A07() {
        this.credentials = new HashMap<>();
        // Add some dummy credentials
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
        this.credentials.put("user3", "password3");
    }

    public boolean validate(String username, String password) {
        // Check if the given credentials match with the stored ones
        if (this.credentials.containsKey(username) && 
            this.credentials.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}