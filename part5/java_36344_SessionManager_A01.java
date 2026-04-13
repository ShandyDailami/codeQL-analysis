import java.util.HashMap;
import java.util.Map;

public class java_36344_SessionManager_A01 {

    // Using HashMap for this example, but in a real-world scenario,
    // it could be any other collection type, such as TreeMap or ConcurrentHashMap.
    private Map<String, String> sessionMap;

    // Default constructor initializes sessionMap
    public java_36344_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    // Method to create a session
    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    // Method to get the userId associated with a session
    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to invalidate a session
    public void invalidateSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Method to check if a session is valid
    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}