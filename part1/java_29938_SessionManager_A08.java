import org.apache.commons.collections4.map.MultiValueMap;
import org.apache.commons.collections4.map.HashedMap;

public class java_29938_SessionManager_A08 {

    private MultiValueMap<String, Session> sessions;

    public java_29938_SessionManager_A08() {
        sessions = new HashedMap<>();
    }

    public void startSession(String userId) {
        Session session = new Session(userId);
        sessions.put(userId, session);
    }

    public Session getSession(String userId) {
        return sessions.get(userId);
    }

    public void endSession(String userId) {
        sessions.remove(userId);
    }

    public static class Session {

        private String userId;
        private long startTime;

        public java_29938_SessionManager_A08(String userId) {
            this.userId = userId;
            this.startTime = System.currentTimeMillis();
        }

        public String getUserId() {
            return userId;
        }

        public long getSessionTime() {
            return System.currentTimeMillis() - startTime;
        }
    }
}