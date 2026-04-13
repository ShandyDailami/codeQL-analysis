import java.util.HashMap;
import java.util.Map;

public class java_29595_SessionManager_A03 {
    private Map<String, String> sessions;

    public java_29595_SessionManager_A03() {
        this.sessions = new HashMap<>();
    }

    public String getSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            return sessions.get(sessionId);
        }
        return null;
    }

    public void setSession(String sessionId, String sessionValue) {
        sessions.put(sessionId, sessionValue);
    }

    public void invalidateSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            sessions.remove(sessionId);
        }
    }

    public boolean isValidSession(String sessionId, String expectedValue) {
        if (sessions.containsKey(sessionId)) {
            return sessions.get(sessionId).equals(expectedValue);
        }
        return false;
    }
}