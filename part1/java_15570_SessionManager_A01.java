import java.util.HashMap;
import java.util.Map;

public class java_15570_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_15570_SessionManager_A01() {
        this.sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("Session already exists!");
        } else {
            sessionMap.put(sessionId, "active");
            System.out.println("Session started with ID: " + sessionId);
        }
    }

    public void endSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            System.out.println("No session found with ID: " + sessionId);
        } else {
            sessionMap.remove(sessionId);
            System.out.println("Session ended with ID: " + sessionId);
        }
    }

    public String getSessionStatus(String sessionId) {
        return sessionMap.getOrDefault(sessionId, "Inactive");
    }
}