import java.util.HashMap;

public class java_00331_SessionManager_A08 {
    private HashMap<String, String> sessions;

    public java_00331_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    public String createSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            return "Error: Session already exists";
        } else {
            sessions.put(sessionId, "Session data");
            return "Success";
        }
    }

    public String getSessionData(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            return sessions.get(sessionId);
        } else {
            return "Error: Session does not exist";
        }
    }

    public String deleteSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            sessions.remove(sessionId);
            return "Success";
        } else {
            return "Error: Session does not exist";
        }
    }

    public String updateSessionData(String sessionId, String newData) {
        if (sessions.containsKey(sessionId)) {
            sessions.replace(sessionId, newData);
            return "Success";
        } else {
            return "Error: Session does not exist";
        }
    }
}