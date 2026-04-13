import java.util.HashMap;
import java.util.Map;

public class java_30537_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_30537_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String username, String sessionId) {
        sessionMap.put(sessionId, username);
        System.out.println("Started session for user: " + username);
    }

    public void endSession(String sessionId) {
        String username = sessionMap.get(sessionId);
        if (username != null) {
            sessionMap.remove(sessionId);
            System.out.println("Ended session for user: " + username);
        } else {
            System.out.println("No user found for session: " + sessionId);
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        sessionManager.startSession("Alice", "A123");
        sessionManager.startSession("Bob", "B456");
        sessionManager.endSession("A123");
        sessionManager.endSession("B456");
        sessionManager.endSession("C789"); // No session found
    }
}