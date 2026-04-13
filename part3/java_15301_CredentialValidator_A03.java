import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_15301_CredentialValidator_A03 {
    private Map<String, String> credentials;

    public java_15301_CredentialValidator_A03() {
        this.credentials = new HashMap<>();
        this.credentials.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        this.credentials.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    public boolean validateCredentials(String username, String password) {
        if (credentials.containsKey(username) && credentials.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}