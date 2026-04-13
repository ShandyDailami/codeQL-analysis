import java.util.HashMap;
import java.util.Map;

public class java_19576_SessionManager_A07 {
    private Map<String, String> userData;

    public java_19576_SessionManager_A07() {
        userData = new HashMap<>();
    }

    public void login(String username, String password) {
        // Avoid storing passwords in plain text
        // This is a simplistic example and not suitable for a real application
        userData.put(username, password);
    }

    public String getUserPassword(String username) {
        return userData.get(username);
    }

    public void logout(String username) {
        userData.remove(username);
    }
}