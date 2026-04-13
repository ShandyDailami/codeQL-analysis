import java.util.Hashtable;

public class java_15221_SessionManager_A01 implements SessionManager {
    // Store sessions in a hashtable
    private Hashtable<String, Session> sessions;

    public java_15221_SessionManager_A01() {
        sessions = new Hashtable<>();
    }

    @Override
    public Session createSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            System.out.println("Session with id " + sessionId + " already exists.");
            return null;
        }

        Session session = new Session(sessionId);
        sessions.put(sessionId, session);
        return session;
    }

    @Override
    public Session getSession(String sessionId) {
        if (!sessions.containsKey(sessionId)) {
            System.out.println("Session with id " + sessionId + " does not exist.");
            return null;
        }

        return sessions.get(sessionId);
    }

    @Override
    public void updateSession(Session session) {
        if (!sessions.containsKey(session.getId())) {
            System.out.println("Session with id " + session.getId() + " does not exist.");
            return;
        }

        sessions.put(session.getId(), session);
    }

    @Override
    public void deleteSession(String sessionId) {
        if (!sessions.containsKey(sessionId)) {
            System.out.println("Session with id " + sessionId + " does not exist.");
            return;
        }

        sessions.remove(sessionId);
    }
}