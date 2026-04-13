import java.util.HashMap;

public class java_01663_SessionManager_A07 {
    private HashMap<String, HashMap<String, Object>> sessions;

    public java_01663_SessionManager_A07() {
        sessions = new HashMap<>();
    }

    public void addSession(String sessionId, HashMap<String, Object> session) {
        sessions.put(sessionId, session);
    }

    public HashMap<String, Object> getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessions.remove(sessionId);
    }
}