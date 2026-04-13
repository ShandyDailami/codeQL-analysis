import java.util.HashMap;
import java.util.Map;

public class java_05699_CredentialValidator_A01 {
    private Map<String, String> credentials;

    public java_05699_CredentialValidator_A01() {
        this.credentials = new HashMap<>();
        this.credentials.put("admin", "password");
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
    }

    public boolean validate(String username, String password) {
        if (credentials.containsKey(username) && credentials.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}