import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class java_15571_SessionManager_A08 {
    private Map<String, Session> sessionMap;

    public java_15571_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return "Error: Session with ID " + sessionId + " already exists.";
        }
        Session session = new Session(sessionId);
        sessionMap.put(sessionId, session);
        return "Successfully created session with ID " + sessionId;
    }

    public String deleteSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            return "Error: No session with ID " + sessionId + " exists.";
        }
        sessionMap.remove(sessionId);
        return "Successfully deleted session with ID " + sessionId;
    }

    public List<String> getAllSessions() {
        List<String> sessionIds = new ArrayList<>();
        for (Session session : sessionMap.values()) {
            sessionIds.add(session.getId());
        }
        return sessionIds;
    }

    private class Session {
        private String id;

        public java_15571_SessionManager_A08(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }
    }
}