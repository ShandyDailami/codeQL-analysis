import java.util.HashMap;
import java.util.Map;

public class java_20321_CredentialValidator_A03 {
    private Map<String, String> credentials;

    public java_20321_CredentialValidator_A03() {
        // Hardcoded set of credentials
        this.credentials = new HashMap<>();
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
        this.credentials.put("user3", "password3");
    }

    public boolean validate(String username, String password) {
        // If the username and password match the hardcoded set
        // Return true, otherwise return false.
        if (this.credentials.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}