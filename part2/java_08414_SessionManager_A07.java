import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class java_08414_SessionManager_A07 {
    private HashMap<String, Session> sessions;
    private int sessionIdCounter;

    public java_08414_SessionManager_A07() {
        sessions = new HashMap<>();
        sessionIdCounter = 0;
    }

    public String createSession() {
        String sessionId = String.valueOf(sessionIdCounter);
        sessions.put(sessionId, new Session());
        sessionIdCounter++;
        return sessionId;
    }

    public Session getSession(String sessionId) {
        Session session = sessions.get(sessionId);
        if (session == null) {
            throw new IllegalArgumentException("Invalid session id: " + sessionId);
        }
        return session;
    }

    public void closeSession(String sessionId) {
        Session session = getSession(sessionId);
        sessions.remove(sessionId);
    }

    public Collection<Session> getAllSessions() {
        return new ArrayList<>(sessions.values());
    }

    private static class Session {
        // Session-specific data goes here
    }
}