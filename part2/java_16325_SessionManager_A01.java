import java.util.HashMap;
import java.util.Map;

public class java_16325_SessionManager_A01 {

    private Map<String, String> sessionMap;

    public java_16325_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Error: Session already exists. Use a different session ID.");
        } else {
            sessionMap.put(sessionId, userId);
            System.out.println("Created session with ID: " + sessionId);
        }
    }

    public void getSessionUser(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("User ID for session ID " + sessionId + " is: " + sessionMap.get(sessionId));
        } else {
            System.out.println("Error: No session found with ID: " + sessionId);
        }
    }

    public void destroySession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
            System.out.println("Destroyed session with ID: " + sessionId);
        } else {
            System.out.println("Error: No session found with ID: " + sessionId);
        }
    }

    public void destroyAllSessions() {
        if (sessionMap.isEmpty()) {
            System.out.println("No session found.");
        } else {
            sessionMap.clear();
            System.out.println("Destroyed all sessions");
        }
    }
}