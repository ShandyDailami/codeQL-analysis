public class java_19591_SessionManager_A07 {
    private static HashMap<String, Session> sessions = new HashMap<String, Session>();

    public static Session getSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            return sessions.get(sessionId);
        } else {
            Session newSession = new Session(sessionId);
            sessions.put(sessionId, newSession);
            return newSession;
        }
    }

    public static void invalidateSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            sessions.remove(sessionId);
        }
    }
}

class Session {
    private String sessionId;

    public java_19591_SessionManager_A07(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getSessionId() {
        return sessionId;
    }
}