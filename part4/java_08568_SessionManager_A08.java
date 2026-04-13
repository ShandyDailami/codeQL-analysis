import java.util.HashMap;
import java.util.Map;

public class java_08568_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_08568_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId) {
        sessionMap.put(sessionId, sessionId);
    }

    public void endSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        } else {
            throw new IllegalStateException("No session found for sessionId: " + sessionId);
        }
    }

    public void validateSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("Session not found for sessionId: " + sessionId);
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        String session1Id = "session1";
        String session2Id = "session2";

        sessionManager.startSession(session1Id);
        sessionManager.validateSession(session1Id);

        sessionManager.startSession(session2Id);
        sessionManager.validateSession(session2Id);

        sessionManager.endSession(session1Id);
        sessionManager.validateSession(session1Id);

        sessionManager.endSession(session2Id);
        sessionManager.validateSession(session2Id);
    }
}