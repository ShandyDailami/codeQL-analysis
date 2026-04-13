import java.util.ArrayList;

public class java_38368_SessionManager_A08 {
    private ArrayList<Session> sessions;
    private int currentSessionIndex;

    public java_38368_SessionManager_A08() {
        sessions = new ArrayList<>();
        currentSessionIndex = 0;
    }

    public Session createSession() {
        Session session = new Session();
        sessions.add(session);
        return session;
    }

    public void removeSession(Session session) {
        sessions.remove(session);
    }

    public int getSessionCount() {
        return sessions.size();
    }

    public Session getSessionByIndex(int index) {
        if (index < 0 || index >= sessions.size()) {
            return null;
        }
        return sessions.get(index);
    }

    public Session getCurrentSession() {
        if (currentSessionIndex < 0 || currentSessionIndex >= sessions.size()) {
            return null;
        }
        return sessions.get(currentSessionIndex);
    }

    private class Session {
        // This class represents a session, but it is not really necessary for a simple example.
        // You could have more fields in the Session class, and more methods.
    }
}