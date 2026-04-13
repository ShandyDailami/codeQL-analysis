import java.util.HashMap;
import java.util.Map;

public class java_39144_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_39144_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId) {
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }

        if (sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("A session with ID " + sessionId + " already exists");
        }

        sessionMap.put(sessionId, "active");
    }

    public void endSession(String sessionId) {
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }

        if (!sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("No session with ID " + sessionId + " exists");
        }

        sessionMap.remove(sessionId);
    }

    public String getSessionState(String sessionId) {
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }

        return sessionMap.get(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        sessionManager.startSession("session1");
        sessionManager.startSession("session2");

        System.out.println("Session 1 state: " + sessionManager.getSessionState("session1"));
        System.out.println("Session 2 state: " + sessionManager.getSessionState("session2"));

        sessionManager.endSession("session1");

        System.out.println("Session 1 state after end: " + sessionManager.getSessionState("session1"));
    }
}