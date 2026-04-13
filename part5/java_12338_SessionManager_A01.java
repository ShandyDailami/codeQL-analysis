import java.util.HashMap;
import java.util.Map;

public class java_12338_SessionManager_A01 implements SessionManager {
    private Map<String, Session> sessionMap;

    public java_12338_SessionManager_A01() {
        this.sessionMap = new HashMap<>();
    }

    @Override
    public Session createSession() {
        String sessionId = UUID.randomUUID().toString();
        Session session = new SessionImpl(sessionId);
        sessionMap.put(sessionId, session);
        return session;
    }

    @Override
    public Session getSession(String sessionId) {
        Session session = sessionMap.get(sessionId);
        if (session == null) {
            throw new IllegalStateException("No session found with id: " + sessionId);
        }
        return session;
    }

    @Override
    public void closeSession(String sessionId) {
        Session session = sessionMap.get(sessionId);
        if (session == null) {
            throw new IllegalStateException("No session found with id: " + sessionId);
        }
        sessionMap.remove(sessionId);
    }
}