import java.util.HashMap;
import java.util.Map;

public class java_14268_SessionManager_A03 {

    // private field to hold the session data
    private Map<String, Session> sessionMap;

    // static inner class to hold the session data
    public static class Session {
        private String sessionId;
        private User user;

        // constructor and getter methods
    }

    // static inner class to hold the user data
    public static class User {
        private String name;

        // constructor and getter methods
    }

    // constructor
    public java_14268_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // method to create a new session
    public Session createSession(User user) {
        Session session = new Session();
        session.sessionId = String.valueOf(System.currentTimeMillis());
        session.user = user;

        sessionMap.put(session.sessionId, session);
        return session;
    }

    // method to get a session
    public Session getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // method to close a session
    public void closeSession(Session session) {
        sessionMap.remove(session.sessionId);
    }

    // method to check if a session exists
    public boolean isSessionExists(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}