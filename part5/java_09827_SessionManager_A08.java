import java.util.HashMap;
import java.util.HashSet;

public class java_09827_SessionManager_A08 {
    private HashMap<String, Session> sessions;
    private HashSet<String> activeSessions;

    public java_09827_SessionManager_A08() {
        sessions = new HashMap<>();
        activeSessions = new HashSet<>();
    }

    public String createSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            return "Session with ID " + sessionId + " already exists!";
        } else {
            sessions.put(sessionId, new Session(sessionId));
            activeSessions.add(sessionId);
            return "Session created with ID " + sessionId;
        }
    }

    public String destroySession(String sessionId) {
        if (!sessions.containsKey(sessionId)) {
            return "No session with ID " + sessionId + " exists!";
        } else {
            sessions.remove(sessionId);
            activeSessions.remove(sessionId);
            return "Session with ID " + sessionId + " destroyed!";
        }
    }

    public String checkSessionIntegrity(String sessionId) {
        if (!sessions.containsKey(sessionId)) {
            return "No session with ID " + sessionId + " exists!";
        } else if (!activeSessions.contains(sessionId)) {
            return "Session with ID " + sessionId + " is not active!";
        } else {
            return "Session with ID " + sessionId + " is active and valid!";
        }
    }

    private class Session {
        private String id;

        public java_09827_SessionManager_A08(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }
    }
}