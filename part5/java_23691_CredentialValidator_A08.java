import java.util.HashMap;
import java.util.Map;

public class java_23691_CredentialValidator_A08 {

    private Map<String, String> credentials;

    public java_23691_CredentialValidator_A08() {
        this.credentials = new HashMap<>();
        // Add some test data
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
    }

    public boolean validate(String username, String password) {
        if (this.credentials.containsKey(username)) {
            if (this.credentials.get(username).equals(password)) {
                return true;
            }
        }
        return false;
    }
}