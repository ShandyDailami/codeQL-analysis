import java.util.HashMap;
import java.util.Map;

public class java_37903_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_37903_SessionManager_A08() {
        this.sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Session with id " + sessionId + " already exists.");
        } else {
            sessionMap.put(sessionId, userId);
            System.out.println("Started session with id " + sessionId + " for user " + userId);
        }
    }

    public void endSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            String userId = sessionMap.get(sessionId);
            sessionMap.remove(sessionId);
            System.out.println("Ended session with id " + sessionId + " for user " + userId);
        } else {
            System.out.println("No session with id " + sessionId + " found.");
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        sessionManager.startSession("session1", "user1");
        sessionManager.startSession("session2", "user2");
        sessionManager.endSession("session1");
        sessionManager.startSession("session3", "user3");
    }
}