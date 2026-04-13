import java.util.HashMap;
import java.util.Map;

public class java_20770_SessionManager_A03 {

    private Map<String, Object> sessions;

    public java_20770_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    public Object getSession(String sessionId) {
        if (!sessions.containsKey(sessionId)) {
            // create and store session in map, not actually doing any session creation, only storing sessionId
            sessions.put(sessionId, new Object());
        }
        return sessions.get(sessionId);
    }

    public void closeSession(String sessionId) {
        // closing session is not actually doing anything here, just removing the session from the map
        sessions.remove(sessionId);
    }

    public void updateSession(String sessionId) {
        // updating session is not doing anything here, just changing the session object in the map
        sessions.put(sessionId, new Object());
    }
}