import java.util.HashMap;
import java.util.Map;

public class java_05516_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_05516_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String username) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Additional methods for A07_AuthFailure related operations
    // For example, you can add a method to check if a session exists and if a username is valid
    public boolean isSessionValid(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public boolean isUsernameValid(String username) {
        // Here you could add your own logic to check if the username is valid
        // For the purpose of this example, we'll just return true for all usernames
        return true;
    }
}