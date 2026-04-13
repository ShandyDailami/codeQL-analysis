import java.util.HashMap;
import java.util.Map;

public class java_29795_CredentialValidator_A07 {

    private Map<String, String> credentials;

    public java_29795_CredentialValidator_A07() {
        this.credentials = new HashMap<>();
        this.credentials.put("user1", "pass1");
        this.credentials.put("user2", "pass2");
        this.credentials.put("user3", "pass3");
    }

    public boolean validateCredentials(String username, String password) {
        if (this.credentials.containsKey(username) &&
                this.credentials.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}