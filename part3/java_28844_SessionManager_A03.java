import java.util.HashMap;
import java.util.Map;

public class java_28844_SessionManager_A03 {
    private Map<String, Object> sessionData;

    public java_28844_SessionManager_A03() {
        sessionData = new HashMap<>();
    }

    public void startSession(String sessionId) {
        sessionData.put(sessionId, new Object());
    }

    public void endSession(String sessionId) {
        sessionData.remove(sessionId);
    }

    public Object getSession(String sessionId) {
        return sessionData.get(sessionId);
    }

    public static void main(String[] args) {
        CustomSessionManager sessionManager = new CustomSessionManager();

        // Start a session
        String sessionId = "session1";
        sessionManager.startSession(sessionId);

        // Get session data
        Object sessionData = sessionManager.getSession(sessionId);

        // End session
        sessionManager.endSession(sessionId);
    }
}