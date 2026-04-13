import java.util.HashMap;
import java.util.Map;

public class java_08572_SessionManager_A07 {
    private Map<String, String> credentials;

    public java_08572_SessionManager_A07() {
        this.credentials = new HashMap<>();
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
        this.credentials.put("user3", "password3");
    }

    public boolean authenticate(String username, String password) {
        return credentials.get(username) != null && credentials.get(username).equals(password);
    }
}