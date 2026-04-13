import java.util.HashMap;

public class java_17979_SessionManager_A03 {
    private HashMap<String, Session> sessions;
    private int nextSessionId;

    public java_17979_SessionManager_A03() {
        sessions = new HashMap<>();
        nextSessionId = 0;
    }

    public String createSession() {
        String sessionId = String.valueOf(nextSessionId);
        sessions.put(sessionId, new Session(sessionId));
        nextSessionId++;
        return sessionId;
    }

    public Session getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    public void destroySession(String sessionId) {
        sessions.remove(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return sessions.containsKey(sessionId);
    }

    private class Session {
        private String id;

        public java_17979_SessionManager_A03(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}