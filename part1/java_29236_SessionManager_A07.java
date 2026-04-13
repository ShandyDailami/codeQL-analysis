import java.util.HashMap;
import java.util.Map;

public class java_29236_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_29236_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userName) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Error: Session already exists with id: " + sessionId);
        } else {
            sessionMap.put(sessionId, userName);
            System.out.println("Session started with id: " + sessionId + ", user: " + userName);
        }
    }

    public void endSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            String userName = sessionMap.get(sessionId);
            sessionMap.remove(sessionId);
            System.out.println("Session ended with id: " + sessionId + ", user: " + userName);
        } else {
            System.out.println("Error: No session found with id: " + sessionId);
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        sessionManager.startSession("A123", "John");
        sessionManager.startSession("A456", "Mary");
        sessionManager.endSession("A123");
        sessionManager.startSession("A789", "Mike");
        sessionManager.endSession("A456");
    }
}