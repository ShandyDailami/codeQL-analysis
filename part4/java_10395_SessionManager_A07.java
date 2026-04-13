import java.util.HashMap;
import java.util.Map;

public class java_10395_SessionManager_A07 {
    private Map<String, String> userMap;

    public java_10395_SessionManager_A07() {
        userMap = new HashMap<>();
    }

    public boolean authenticate(String username, String password) {
        // This is a dummy authentication process.
        // In reality, you would typically use a more secure method to compare passwords.
        if (username.equals("admin") && password.equals("password")) {
            return true;
        }
        return false;
    }

    public void storeSession(String sessionId, String username) {
        if (authenticate(username, "password")) {
            userMap.put(sessionId, username);
        } else {
            // Handle auth failure here.
        }
    }

    public String retrieveSession(String sessionId) {
        return userMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        userMap.remove(sessionId);
    }
}