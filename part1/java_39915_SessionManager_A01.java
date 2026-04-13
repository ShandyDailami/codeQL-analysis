import java.util.HashMap;
import java.util.Map;

public class java_39915_SessionManager_A01 {
    private Map<String, Session> sessions = new HashMap<>();

    public Session getSession(String key) {
        if (sessions.containsKey(key)) {
            return sessions.get(key);
        } else {
            throw new SecurityException("Unauthorized access to session " + key);
        }
    }

    public void createSession(String key, Session session) {
        if (sessions.containsKey(key)) {
            throw new SecurityException("Session " + key + " already exists");
        } else {
            sessions.put(key, session);
        }
    }

    public void updateSession(String key, Session session) {
        if (sessions.containsKey(key)) {
            sessions.put(key, session);
        } else {
            throw new SecurityException("Unauthorized access to session " + key);
        }
    }

    public void deleteSession(String key) {
        if (sessions.containsKey(key)) {
            sessions.remove(key);
        } else {
            throw new SecurityException("Unauthorized access to session " + key);
        }
    }
}