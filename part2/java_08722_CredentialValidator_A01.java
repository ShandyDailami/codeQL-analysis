import java.util.HashMap;
import java.util.Map;

public class java_08722_CredentialValidator_A01 {

    private Map<String, String> credentials;

    public java_08722_CredentialValidator_A01() {
        this.credentials = new HashMap<>();
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
        this.credentials.put("user3", "password3");
    }

    public boolean validateCredentials(String username, String password) {
        if (credentials.containsKey(username) && credentials.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}