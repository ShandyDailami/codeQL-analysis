import java.util.HashMap;

public class java_16311_SessionManager_A03 {
    private HashMap<Integer, Session> sessions = new HashMap<>();
    private int sessionIdCounter = 0;

    public int startSession() {
        sessions.put(sessionIdCounter, new Session());
        return sessionIdCounter++;
    }

    public Session getSession(int id) {
        return sessions.get(id);
    }

    public void setSessionAttribute(int id, String attributeName, Object attributeValue) {
        Session session = sessions.get(id);
        if (session != null) {
            session.setAttribute(attributeName, attributeValue);
        }
    }

    public Object getSessionAttribute(int id, String attributeName) {
        Session session = sessions.get(id);
        if (session != null) {
            return session.getAttribute(attributeName);
        }
        return null;
    }

    public void stopSession(int id) {
        sessions.remove(id);
    }

    private class Session {
        private HashMap<String, Object> attributes = new HashMap<>();

        public Object getAttribute(String name) {
            return attributes.get(name);
        }

        public void setAttribute(String name, Object value) {
            attributes.put(name, value);
        }
    }
}