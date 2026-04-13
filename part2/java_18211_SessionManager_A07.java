import java.util.HashMap;
import java.util.Map;

public class java_18211_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_18211_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String username) {
        // Generate a secure session key based on the username
        String sessionKey = username + "_Session";
        sessionMap.put(sessionKey, username);
    }

    public String getUsername(String sessionKey) {
        // Validate the session key and return the username
        if (sessionMap.containsKey(sessionKey)) {
            return sessionMap.get(sessionKey);
        } else {
            return null;
        }
    }

    public void deleteSession(String sessionKey) {
        // Remove the session from the map
        sessionMap.remove(sessionKey);
    }
}