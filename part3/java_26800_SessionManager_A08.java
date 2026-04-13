import java.util.HashMap;
import java.util.Map;

public class java_26800_SessionManager_A08 {

    private Map<String, Session> sessions;

    public java_26800_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    public void startSession(String username) {
        if (sessions.containsKey(username)) {
            throw new IllegalStateException("Session already started for user: " + username);
        }

        Session session = new Session(username);
        sessions.put(username, session);
    }

    public void endSession(String username) {
        if (!sessions.containsKey(username)) {
            throw new IllegalStateException("No session started for user: " + username);
        }

        sessions.remove(username);
    }

    public void checkSession(String username) {
        if (!sessions.containsKey(username)) {
            throw new IllegalStateException("No session started for user: " + username);
        }

        Session session = sessions.get(username);

        if (session.isExpired()) {
            throw new IllegalStateException("Session expired for user: " + username);
        }
    }

    private class Session {
        private String username;
        private long startTime;

        public java_26800_SessionManager_A08(String username) {
            this.username = username;
            this.startTime = System.currentTimeMillis();
        }

        public boolean isExpired() {
            long currentTime = System.currentTimeMillis();
            long sessionDuration = 1000 * 60 * 10; // 10 minutes

            return (currentTime - startTime) > sessionDuration;
        }
    }
}