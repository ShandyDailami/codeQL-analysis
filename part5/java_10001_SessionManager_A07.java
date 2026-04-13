import java.util.HashMap;
import java.util.Map;

public class java_10001_SessionManager_A07 {

    private Map<String, String> credentials;

    public java_10001_SessionManager_A07() {
        this.credentials = new HashMap<>();
    }

    public void addCredential(String username, String password) {
        this.credentials.put(username, password);
    }

    public boolean authenticate(String username, String password) {
        if (this.credentials.containsKey(username) && this.credentials.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}