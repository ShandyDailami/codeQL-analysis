import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class java_21419_SessionManager_A01 {
    private static List<String> allowedHosts = new ArrayList<>();
    private HashMap<String, Session> sessions = new HashMap<>();

    public java_21419_SessionManager_A01() {
        allowedHosts.add("localhost");
    }

    public String createSession(String host) {
        if (allowedHosts.contains(host)) {
            String sessionId = UUID.randomUUID().toString();
            sessions.put(sessionId, new Session(sessionId));
            return sessionId;
        } else {
            throw new SecurityException("Unable to create session, host not allowed.");
        }
    }

    public Session getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    public void destroySession(String sessionId) {
        sessions.remove(sessionId);
    }

    public static class Session {
        private String sessionId;

        public java_21419_SessionManager_A01(String sessionId) {
            this.sessionId = sessionId;
        }

        public String getSessionId() {
            return sessionId;
        }
    }
}