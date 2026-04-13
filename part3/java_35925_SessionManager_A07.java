import java.util.HashMap;
import java.util.Map;

public class java_35925_SessionManager_A07 {

    // Create a Map to store the sessions
    private Map<String, String> sessionMap;

    // The constructor
    public java_35925_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String userName) {
        String sessionId = Integer.toHexString(userName.hashCode());
        sessionMap.put(sessionId, userName);
        return sessionId;
    }

    // Method to validate a session
    public String getUserName(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to delete a session
    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // A method to check if a session is valid
    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}