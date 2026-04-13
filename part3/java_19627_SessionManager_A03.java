import java.util.*;

public class java_19627_SessionManager_A03 {
    private Map<String, String> sessions;

    public java_19627_SessionManager_A03() {
        this.sessions = new HashMap<>();
    }

    public void createSession(String sessionId, String sessionData) {
        this.sessions.put(sessionId, sessionData);
    }

    public String getSessionData(String sessionId) {
        if (this.sessions.containsKey(sessionId)) {
            return this.sessions.get(sessionId);
        } else {
            return null;
        }
    }

    public void updateSessionData(String sessionId, String newData) {
        if (this.sessions.containsKey(sessionId)) {
            this.sessions.put(sessionId, newData);
        }
    }

    public void deleteSession(String sessionId) {
        if (this.sessions.containsKey(sessionId)) {
            this.sessions.remove(sessionId);
        }
    }
}