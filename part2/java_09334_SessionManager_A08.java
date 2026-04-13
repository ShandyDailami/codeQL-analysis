import java.util.HashMap;
import java.util.Map;

public class java_09334_SessionManager_A08 {
    private Map<String, Session> sessionMap;

    public java_09334_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public Session getSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            Session session = new Session();
            sessionMap.put(sessionId, session);
            System.out.println("Created new session with ID: " + sessionId);
        }

        return sessionMap.get(sessionId);
    }

    public void closeSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
            System.out.println("Closed session with ID: " + sessionId);
        }
    }

    public class Session {
        // This class represents a session object and could contain session-specific data.
    }
}