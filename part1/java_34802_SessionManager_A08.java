import java.util.HashMap;
import java.util.Map;

public class java_34802_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_34802_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}

public class Main {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        String user1 = "User1";
        String user2 = "User2";

        // Start a session for user1
        String session1 = sessionManager.startSession(user1);

        // Start a session for user2
        String session2 = sessionManager.startSession(user2);

        // Check if both sessions are valid
        if (sessionManager.isValidSession(session1) && sessionManager.isValidSession(session2)) {
            System.out.println("Sessions are valid.");
        } else {
            System.out.println("Sessions are invalid.");
        }

        // End session for user1
        sessionManager.endSession(session1);

        // Check if session for user2 is valid
        if (sessionManager.isValidSession(session2)) {
            System.out.println("Session for user2 is still valid.");
        } else {
            System.out.println("Session for user2 is no longer valid.");
        }
    }
}