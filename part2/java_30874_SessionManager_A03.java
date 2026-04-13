import java.util.HashMap;
import java.util.Map;

public class java_30874_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_30874_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Session already exists with id " + sessionId);
        } else {
            sessionMap.put(sessionId, userId);
            System.out.println("Started session with id " + sessionId);
        }
    }

    public void endSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
            System.out.println("Ended session with id " + sessionId);
        } else {
            System.out.println("No session found with id " + sessionId);
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        sessionManager.startSession("session1", "user1");
        sessionManager.startSession("session2", "user2");

        sessionManager.endSession("session1");
        sessionManager.endSession("session3");
    }
}