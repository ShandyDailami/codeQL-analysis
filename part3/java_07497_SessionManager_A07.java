import java.util.HashMap;
import java.util.Map;

public class java_07497_SessionManager_A07 {

    private Map<String, String> sessionMap;

    public java_07497_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String username) {
        if (sessionMap.containsKey(username)) {
            System.out.println("Session already exists for user: " + username);
        } else {
            String sessionId = generateSessionId();
            sessionMap.put(username, sessionId);
            System.out.println("Session started for user: " + username + ", Session ID: " + sessionId);
        }
    }

    public void endSession(String username) {
        if (sessionMap.containsKey(username)) {
            String sessionId = sessionMap.get(username);
            sessionMap.remove(username);
            System.out.println("Session ended for user: " + username + ", Session ID: " + sessionId);
        } else {
            System.out.println("No session found for user: " + username);
        }
    }

    private String generateSessionId() {
        // Implementation of generating a session ID
        // For example, you can use the current time in milliseconds
        return String.valueOf(System.currentTimeMillis());
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();
        manager.startSession("John");
        manager.startSession("John");
        manager.endSession("John");
        manager.startSession("Mary");
    }
}