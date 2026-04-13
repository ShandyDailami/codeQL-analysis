import java.util.HashMap;
import java.util.Map;

public class java_11127_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_11127_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Session with ID " + sessionId + " already exists. Please log in instead.");
        } else {
            sessionMap.put(sessionId, userId);
            System.out.println("Session created for user with ID " + userId + ".");
        }
    }

    public void deleteSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            System.out.println("No session with ID " + sessionId + " exists.");
        } else {
            String userId = sessionMap.get(sessionId);
            sessionMap.remove(sessionId);
            System.out.println("Session deleted for user with ID " + userId + ".");
        }
    }

    public void validateSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            System.out.println("No session with ID " + sessionId + " exists.");
        } else {
            String userId = sessionMap.get(sessionId);
            System.out.println("Session validated for user with ID " + userId + ".");
        }
    }
}