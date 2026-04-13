import java.util.HashMap;
import java.util.Map;

public class java_42133_SessionManager_A07 {
    private Map<String, Session> sessionMap;

    public java_42133_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public Session getSession(String userId) {
        Session session = sessionMap.get(userId);
        if (session == null) {
            session = createSession(userId);
            sessionMap.put(userId, session);
        }
        return session;
    }

    private Session createSession(String userId) {
        // Mock of creating a session
        Session session = new Session();
        session.setUserId(userId);
        session.setLoggedIn(true);
        return session;
    }

    public void logout(Session session) {
        // Security-sensitive operation: logging out
        session.setLoggedIn(false);
        sessionMap.remove(session.getUserId());
    }
}