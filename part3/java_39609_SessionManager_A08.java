import java.util.HashMap;
import java.util.Map;

public class java_39609_SessionManager_A08 {
    private Map<String, Session> sessionMap;

    public java_39609_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return "Session already exists";
        } else {
            Session session = new Session(sessionId);
            sessionMap.put(sessionId, session);
            return "Session created successfully";
        }
    }

    public String getSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId).getId();
        } else {
            return "Session not found";
        }
    }

    public String deleteSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
            return "Session deleted successfully";
        } else {
            return "Session not found";
        }
    }
}

class Session {
    private String id;

    public java_39609_SessionManager_A08(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }
}