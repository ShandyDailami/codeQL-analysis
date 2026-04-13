import java.util.HashMap;
import java.util.Map;

public class java_09444_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_09444_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userName) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("A session with id " + sessionId + " already exists. Please login first.");
        } else {
            sessionMap.put(sessionId, userName);
            System.out.println("Session started with id " + sessionId + " for user " + userName + ".");
        }
    }

    public void endSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            String userName = sessionMap.get(sessionId);
            sessionMap.remove(sessionId);
            System.out.println("Session ended with id " + sessionId + " for user " + userName + ".");
        } else {
            System.out.println("No session with id " + sessionId + " exists.");
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        sessionManager.startSession("session1", "User1");
        sessionManager.startSession("session2", "User2");
        sessionManager.endSession("session1");
        sessionManager.startSession("session3", "User3"); // Should fail as session1 is already started
    }
}