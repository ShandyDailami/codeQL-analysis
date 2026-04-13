import java.util.HashMap;
import java.util.Map;

public class java_07674_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_07674_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Error: Session already exists for user: " + sessionId);
        } else {
            sessionMap.put(sessionId, userId);
            System.out.println("Session started for user: " + userId);
        }
    }

    public void endSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            String userId = sessionMap.get(sessionId);
            sessionMap.remove(sessionId);
            System.out.println("Session ended for user: " + userId);
        } else {
            System.out.println("Error: No session found for user: " + sessionId);
        }
    }

    public void checkSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            String userId = sessionMap.get(sessionId);
            System.out.println("Session found for user: " + userId);
        } else {
            System.out.println("Error: No session found for user: " + sessionId);
        }
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();
        manager.startSession("s1", "u1");
        manager.startSession("s2", "u2");
        manager.startSession("s1", "u3"); // Error: Session already exists for user: s1
        manager.checkSession("s1"); // Error: No session found for user: s2
        manager.endSession("s1");
        manager.checkSession("s1"); // Error: No session found for user: s1
        manager.endSession("s2");
    }
}