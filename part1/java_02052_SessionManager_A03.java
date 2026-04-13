import java.util.HashMap;

public class java_02052_SessionManager_A03 {

    private static HashMap<String, Session> sessions = new HashMap<>();
    private static int maxSessions = 10;

    public static class Session {
        // Session data
    }

    public static Session createSession() {
        if (sessions.size() < maxSessions) {
            Session newSession = new Session();
            sessions.put(newSession.toString(), newSession);
            return newSession;
        } else {
            throw new RuntimeException("Max sessions reached");
        }
    }

    public static Session getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    public static void destroySession(String sessionId) {
        sessions.remove(sessionId);
    }

    public static void main(String[] args) {
        Session session = createSession();
        // You can now use the session here
    }
}