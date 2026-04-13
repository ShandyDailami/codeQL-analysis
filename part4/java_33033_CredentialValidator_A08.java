import java.util.HashMap;
import java.util.Map;

public class java_33033_CredentialValidator_A08 {
    private Map<String, String> credentials;

    public java_33033_CredentialValidator_A08() {
        this.credentials = new HashMap<>();
        this.credentials.put("admin", "password123");
        this.credentials.put("user1", "user123");
        this.credentials.put("user2", "user222");
    }

    public boolean validate(String username, String password) {
        return password.equals(this.credentials.getOrDefault(username, ""));
    }
}