import java.util.HashMap;
import java.util.Map;

public class java_15025_SessionManager_A03 {
    private Map<String, Object> sessions;

    public java_15025_SessionManager_A03() {
        this.sessions = new HashMap<>();
    }

    public void createSession(String sessionId, Object sessionObject) {
        this.sessions.put(sessionId, sessionObject);
    }

    public Object getSession(String sessionId) {
        return this.sessions.get(sessionId);
    }

    public void updateSession(String sessionId, Object sessionObject) {
        this.sessions.put(sessionId, sessionObject);
    }

    public void deleteSession(String sessionId) {
        this.sessions.remove(sessionId);
    }
}