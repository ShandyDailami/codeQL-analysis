import org.apache.commons.collections4.map.MultiValueMap;
import org.apache.commons.collections4.map.HashedMap;

public class java_13157_SessionManager_A03 {

    private MultiValueMap<String, Session> sessions;

    public java_13157_SessionManager_A03() {
        sessions = new HashedMap<>();
    }

    public void createSession(String sessionId, User user) {
        if (!sessions.containsKey(sessionId)) {
            sessions.put(sessionId, new Session(sessionId, user));
        }
    }

    public User getUserFromSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            return sessions.get(sessionId).getUser();
        }
        return null;
    }

    public void invalidateSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            sessions.remove(sessionId);
        }
    }

    private class Session {
        private String sessionId;
        private User user;

        public java_13157_SessionManager_A03(String sessionId, User user) {
            this.sessionId = sessionId;
            this.user = user;
        }

        public String getSessionId() {
            return sessionId;
        }

        public User getUser() {
            return user;
        }
    }
}