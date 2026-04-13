import java.util.HashMap;
import java.util.Map;

public class java_19529_SessionManager_A07 {
    private Map<String, String> sessions;

    public java_19529_SessionManager_A07() {
        this.sessions = new HashMap<>();
    }

    public void startSession(String userId) {
        // In a real-world application, this operation should be secure,
        // and it should not be allowed to fail for any user.
        // For simplicity, we will just store the userId in the session.
        this.sessions.put("session_" + userId, userId);
    }

    public void endSession(String userId) {
        // In a real-world application, this operation should be secure,
        // and it should not be allowed to fail for any user.
        // For simplicity, we will just remove the userId from the session.
        this.sessions.remove("session_" + userId);
    }

    public String getUserId(String sessionId) {
        // In a real-world application, this operation should be secure,
        // and it should not be allowed to fail for any session.
        // For simplicity, we will just return the userId from the session.
        return this.sessions.get(sessionId);
    }
}