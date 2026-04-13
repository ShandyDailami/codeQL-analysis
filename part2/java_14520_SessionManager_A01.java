import java.util.HashMap;
import java.util.Map;

public class java_14520_SessionManager_A01 {
    private Map<String, String> sessions;

    public java_14520_SessionManager_A01() {
        this.sessions = new HashMap<>();
    }

    public String getSession(String sessionId) {
        return this.sessions.get(sessionId);
    }

    public void createSession(String sessionId, String sessionData) {
        this.sessions.put(sessionId, sessionData);
    }

    public void deleteSession(String sessionId) {
        this.sessions.remove(sessionId);
    }

    public void updateSession(String sessionId, String newSessionData) {
        if (this.sessions.containsKey(sessionId)) {
            this.sessions.put(sessionId, newSessionData);
        } else {
            System.out.println("Session not found!");
        }
    }
}