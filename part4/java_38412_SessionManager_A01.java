import java.util.HashMap;
import java.util.Map;

public class java_38412_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_38412_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String username) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Error: Session already exists.");
        } else {
            sessionMap.put(sessionId, username);
            System.out.println("Session started with ID: " + sessionId);
        }
    }

    public void endSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
            System.out.println("Session ended with ID: " + sessionId);
        } else {
            System.out.println("Error: Session does not exist.");
        }
    }

    public String getUser(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            System.out.println("Error: Session does not exist.");
            return null;
        }
    }

    public boolean isSessionActive(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}