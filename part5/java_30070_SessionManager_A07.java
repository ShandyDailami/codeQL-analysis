import java.util.HashMap;
import java.util.Map;

public class java_30070_SessionManager_A07 implements SessionManagerInterface {
    private static Map<String, Session> sessionMap = new HashMap<>();

    @Override
    public Session createSession(String username) {
        Session session = new Session();
        session.setUsername(username);
        session.setSessionId(UUID.randomUUID().toString());
        sessionMap.put(session.getSessionId(), session);
        return session;
    }

    @Override
    public Session getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    @Override
    public void updateSession(Session session) {
        sessionMap.put(session.getSessionId(), session);
    }

    @Override
    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Implementation of SessionManagerInterface methods
}